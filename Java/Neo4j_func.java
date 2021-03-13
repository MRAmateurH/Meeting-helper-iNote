package com.neo4j.test;

import org.neo4j.driver.*;
import org.neo4j.driver.exceptions.Neo4jException;

import java.util.List;

import static org.neo4j.driver.Values.parameters;

import java.util.HashMap;
import java.util.Map;

public class Neo4j_func implements AutoCloseable
{
	private final Driver driver;

    public Neo4j_func( String uri, String user, String password )
    {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }

    @Override
    public void close() throws Exception
    {
        driver.close();
    }
    
    public void createWord(final char name)
    {
        try ( Session session = driver.session() )
        {  
            session.run("MERGE(w:Word { name: $name })", parameters( "name", name ) );
        }
    }
    
    public void createWord(final String name)
    {
        try ( Session session = driver.session() )
        {  
            session.run("MERGE(w:Word { name: $name })", parameters( "name", name ) );
        }
    }
    
    public void create2Relationship(final char word1, final char word2) {
    	
        final String createRelationshipQuery = "MATCH (w1:Word { name: $word1 })\n " +
        									   "MATCH (w2:Word { name: $word2 })\n" +
                							   "MERGE (w1)-[ r:twoRelations ]->(w2)\n" +
                							   "RETURN w1, w2";

        final Map<String, Object> params = new HashMap<>();
        params.put("word1", word1);
        params.put("word2", word2);

        try (Session session = driver.session()) {
            
            Record record = session.writeTransaction(tx -> {
                Result result = tx.run(createRelationshipQuery, params);
                return result.single();
            });
            System.out.println(String.format("Created friendship between: %s, %s",
                    record.get("w1").get("name").asString(),
                    record.get("w2").get("name").asString()));
        }
    }
    
    public void create2Relationship(final String word1, final String word2) {
    	
        final String createRelationshipQuery = "MATCH (w1:Word { name: $word1 })\n" +
        									   "MATCH (w2:Word { name: $word2 })\n" +
                							   "MERGE (w1)-[ r:twoRelations ]->(w2)\n" +
                							   "RETURN w1, w2";

        final Map<String, Object> params = new HashMap<>();
        params.put("word1", word1);
        params.put("word2", word2);

        try (Session session = driver.session()) {
            
            Record record = session.writeTransaction(tx -> {
                Result result = tx.run(createRelationshipQuery, params);
                return result.single();
            });
            System.out.println(String.format("Created friendship between: %s, %s",
                    record.get("w1").get("name").asString(),
                    record.get("w2").get("name").asString()));
        }
    }
    
    public void set2Property(final char word1, final char word2, final int time) {
	
        final String setPropertyQuery = "MATCH (w1:Word { name: $word1 })-[r:twoRelations]->(w2:Word { name: $word2 })\n" +
										"SET r.time = $time";

        final Map<String, Object> params = new HashMap<>();
        params.put("word1", word1);
        params.put("word2", word2);
        params.put("time", time);

        try (Session session = driver.session()) {
    		
    		session.writeTransaction(tx -> tx.run(setPropertyQuery, params) );
    	}
    }
    
    public void set2Property(final String word1, final String word2, final int time) {
    	
        final String setPropertyQuery = "MATCH (w1:Word { name: $word1 })-[r:twoRelations]->(w2:Word { name: $word2 })\n" +
        								"SET r.time = $time";

        final Map<String, Object> params = new HashMap<>();
        params.put("word1", word1);
        params.put("word2", word2);
        params.put("time", time);

        try (Session session = driver.session()) {
    		
    		session.writeTransaction(tx -> tx.run(setPropertyQuery, params) );
    	}
    }
    
    public void create3Relationship(final char word1, final char word2, final char word3, final int time) {
    	
        final String setPropertyQuery = "MATCH (w2:Word { name: $word2 })\n" +
        								"MATCH (w1:Word { name: $word1 })-[r:threeRelations]->(w3:Word { name: $word3 })\n" +
        								"MERGE (w1)-[:threeRelations {name: $word2, time: $time}]->(w3)\n";

        final Map<String, Object> params = new HashMap<>();
        params.put("word1", word1);
        params.put("word2", word2);
        params.put("word3", word3);
        params.put("time", time);

        try (Session session = driver.session()) {
    		
    		session.writeTransaction(tx -> tx.run(setPropertyQuery, params) );
    	}
        catch (Neo4jException e) {
        	System.out.println("The relationship has been created!");
		}
    }
    
    public void create3Relationship(final String word1, final String word2, final String word3, final int time) {
    	
        final String setPropertyQuery = "MATCH (w1:Word { name: $word1 })\n" +
        								"MATCH (w2:Word { name: $word2 })\n" +
        								"MATCH (w3:Word { name: $word3 })\n" +
        								"MERGE (w1)-[r:threeRelations {name: $word2, time: $time}]->(w3)";

        final Map<String, Object> params = new HashMap<>();
        params.put("word1", word1);
        params.put("word2", word2);
        params.put("word3", word3);
        params.put("time", time);

        try (Session session = driver.session()) {
    		
    		session.writeTransaction(tx -> tx.run(setPropertyQuery, params) );
    	}
        catch (Neo4jException e) {
        	System.out.println("The relationship has been created!");
		}
    }
    
    public static List<Record> get2Time( final String word1, Transaction tx )
    {
        return tx.run( "MATCH (w1:Word { name: $word1 })-[ r:twoRelations ]->(w2:Word)\n" +
					   "RETURN r", parameters( "word1", word1 ) ).list();
    }
    
    public String Modify (final String word1)
    {
        try ( Session session = driver.session() )
        {
        	List<Record> times = session.readTransaction( new TransactionWork<List<Record>>()
            {
                @Override
                public List<Record> execute( Transaction tx )
                {
                    return get2Time( word1, tx );
                }
            } );
        	int Max = times.get(0).get("r").get("time").asInt();
        	
        	for( int i = 1; i < times.size(); i++ )
        	{
        		int maxIndex = times.get(i).get("r").get("time").asInt();
        		if(Max < maxIndex) {
        			Max = maxIndex;
        		}
        	}
        	final int time = Max;
        	Record record = session.writeTransaction(tx -> {
        		Result result = tx.run( "MATCH (w1:Word { name: $word1 })-[ r:twoRelations { time: $time }]->(w2:Word)\n" +
					     				"RETURN w2", parameters( "word1", word1, "time", time ) );
                 return result.single();
            });
        	return record.get("w2").get("name").asString();
        }
    }
    
    public static List<Record> get3Time( final String word1, final String word3, Transaction tx )
    {
        return tx.run( "MATCH (w1:Word { name: $word1 })-[ r:threeRelations ]->(w3:Word { name: $word3 })\n" +
					   "RETURN r", parameters( "word1", word1, "word3", word3 ) ).list();
    }
    
    public String ModifyMidWord (final String word1, final String word3)
    {
        try ( Session session = driver.session() )
        {
        	List<Record> times = session.readTransaction( new TransactionWork<List<Record>>()
            {
                @Override
                public List<Record> execute( Transaction tx )
                {
                    return get3Time( word1, word3, tx );
                }
            } );
        	int Max = times.get(0).get("r").get("time").asInt();
        	
        	for( int i = 1; i < times.size(); i++ )
        	{
        		int maxIndex = times.get(i).get("r").get("time").asInt();
        		if(Max < maxIndex) {
        			Max = maxIndex;
        		}
        	}
        	final int time = Max;
        	Record record = session.writeTransaction(tx -> {
        		Result result = tx.run( "MATCH (w1:Word { name: $word1 })-[ r:threeRelations ]->(w3:Word { name: $word3 })\n" +
        								"WHERE r.time = $time\n" +
					     				"RETURN r", parameters( "word1", word1, "time", time, "word3", word3) );
                 return result.single();
            });
        	return record.get("r").get("name").asString();
        }
    }
}
