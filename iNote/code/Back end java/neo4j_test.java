package neo4j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class testX {
	public static void main(String[] args) throws Exception {
		
		try ( testA greeter = new testA( "bolt://localhost:7687", "neo4j", "123" ) )
        {	
			
			File file = new File("C:\\Users\\user\\Desktop\\output.txt");
			/*File fileo = new File("C:\\Users\\user\\Desktop\\output1.txt");
			if(!fileo.exists()){
				fileo.createNewFile();
        	}
			BufferedWriter out = new BufferedWriter(new FileWriter(fileo,true));*/
	        BufferedReader reader = null;
	        try {
	            reader = new BufferedReader(new FileReader(file));
	            String test = null;
	            while ((test = reader.readLine()) != null) {
	            	String temp1=null;
	            	String temp2=null;
	            	String temp3=null;
	            	boolean correct = true;
	            	ArrayList<String> a = new ArrayList<String>();
	            	ArrayList<String> b = new ArrayList<String>();
	            	for(int i =0; i < test.length()-1; i++) {
	            		if(correct==true) {
		            		temp1 = test.substring(i, i+1);
		            		temp2 = test.substring(i+1, i+2);
		            	}else {
		           			temp1 = temp2;
		           			temp2 = test.substring(i+1, i+2);
		           		}
		           		int k = 0;
		           		if(temp1!=","&& temp1!="¡C"&& temp2!=","&& temp2 !="¡C"&& temp1!="!"&& temp1!="?"&& temp2!="!"&&temp2 !="?"&&
		           				temp1!="A"&&temp1!="B"&&temp1!="c"&&temp1!="D"&&temp1!="E"&&temp1!="F"&&temp1!="G"&&temp1!="H"&&temp1!="I"&&temp1!="J"&&temp1!="K"&&temp1!="L"&&temp1!="M"&&
		            			temp1!="N"&&temp1!="O"&&temp1!="P"&&temp1!="Q"&&temp1!="R"&&temp1!="S"&&temp1!="T"&&temp1!="U"&&temp1!="V"&&temp1!="W"&&temp1!="X"&&temp1!="Y"&&temp1!="Z"&&
		            			temp1!="a"&&temp1!="b"&&temp1!="c"&&temp1!="d"&&temp1!="e"&&temp1!="f"&&temp1!="g"&&temp1!="h"&&temp1!="i"&&temp1!="j"&&temp1!="k"&&temp1!="l"&&temp1!="m"&&
		            			temp1!="n"&&temp1!="o"&&temp1!="p"&&temp1!="q"&&temp1!="r"&&temp1!="s"&&temp1!="t"&&temp1!="u"&&temp1!="v"&&temp1!="w"&&temp1!="x"&&temp1!="y"&&temp1!="z"&&
		            			temp2!="A"&&temp2!="B"&&temp2!="c"&&temp2!="D"&&temp2!="E"&&temp2!="F"&&temp2!="G"&&temp2!="H"&&temp2!="I"&&temp2!="J"&&temp2!="K"&&temp2!="L"&&temp2!="M"&&
		            			temp2!="N"&&temp2!="O"&&temp2!="P"&&temp2!="Q"&&temp2!="R"&&temp2!="S"&&temp2!="T"&&temp2!="U"&&temp2!="V"&&temp2!="W"&&temp2!="X"&&temp2!="Y"&&temp2!="Z"&&
		            			temp2!="a"&&temp2!="b"&&temp2!="c"&&temp2!="d"&&temp2!="e"&&temp2!="f"&&temp2!="g"&&temp2!="h"&&temp2!="i"&&temp2!="j"&&temp2!="k"&&temp2!="l"&&temp2!="m"&&
		            			temp2!="n"&&temp2!="o"&&temp2!="p"&&temp2!="q"&&temp2!="r"&&temp2!="s"&&temp2!="t"&&temp2!="u"&&temp2!="v"&&temp2!="w"&&temp2!="x"&&temp2!="y"&&temp2!="z"&&
		            			temp1!="0"&&temp1!="1"&&temp1!="2"&&temp1!="3"&&temp1!="4"&&temp1!="5"&&temp1!="6"&&temp1!="7"&&temp1!="8"&&temp1!="9"&&
		            			temp2!="0"&&temp2!="1"&&temp2!="2"&&temp2!="3"&&temp2!="4"&&temp2!="5"&&temp2!="6"&&temp2!="7"&&temp2!="8"&&temp2!="9"
		           		) {
		           			try {
		           				k = greeter.getTime(temp1, temp2);
		           			}catch(Exception e){
		           				k = 0;
		           			}
		           		}
		           		if(temp1.equals("¡A") || temp1.equals("¡C") || temp1.equals("!") || temp1.equals("?")||
		           				temp1.equals("A")||temp1.equals("B")||temp1.equals("C")||temp1.equals("D")||temp1.equals("E")||temp1.equals("F")||temp1.equals("G")||temp1.equals("H")||temp1.equals("I")||temp1.equals("J")||temp1.equals("K")||temp1.equals("L")||temp1.equals("M")||
	            				temp1.equals("N")||temp1.equals("O")||temp1.equals("P")||temp1.equals("Q")||temp1.equals("R")||temp1.equals("S")||temp1.equals("T")||temp1.equals("U")||temp1.equals("V")||temp1.equals("W")||temp1.equals("X")||temp1.equals("Y")||temp1.equals("Z")||
	            				temp1.equals("a")||temp1.equals("b")||temp1.equals("c")||temp1.equals("d")||temp1.equals("e")||temp1.equals("f")||temp1.equals("g")||temp1.equals("h")||temp1.equals("i")||temp1.equals("j")||temp1.equals("k")||temp1.equals("l")||temp1.equals("m")||
	            				temp1.equals("n")||temp1.equals("o")||temp1.equals("p")||temp1.equals("q")||temp1.equals("r")||temp1.equals("s")||temp1.equals("t")||temp1.equals("u")||temp1.equals("v")||temp1.equals("w")||temp1.equals("x")||temp1.equals("y")||temp1.equals("z")||
	            				temp1.equals("0")||temp1.equals("1")||temp1.equals("2")||temp1.equals("3")||temp1.equals("4")||temp1.equals("5")||temp1.equals("6")||temp1.equals("7")||temp1.equals("8")||temp1.equals("9")||
	            				temp2.equals("¡A")||temp2.equals("¡C")||temp2.equals("!")||temp2.equals("?")||
		           				temp2.equals("A")||temp2.equals("B")||temp2.equals("C")||temp2.equals("D")||temp2.equals("E")||temp2.equals("F")||temp2.equals("G")||temp2.equals("H")||temp2.equals("I")||temp2.equals("J")||temp2.equals("K")||temp2.equals("L")||temp2.equals("M")||
	            				temp2.equals("N")||temp2.equals("O")||temp2.equals("P")||temp2.equals("Q")||temp2.equals("R")||temp2.equals("S")||temp2.equals("T")||temp2.equals("U")||temp2.equals("V")||temp2.equals("W")||temp2.equals("X")||temp2.equals("Y")||temp2.equals("Z")||
	            				temp2.equals("a")||temp2.equals("b")||temp2.equals("c")||temp2.equals("d")||temp2.equals("e")||temp2.equals("f")||temp2.equals("g")||temp2.equals("h")||temp2.equals("i")||temp2.equals("j")||temp2.equals("k")||temp2.equals("l")||temp2.equals("m")||
	            				temp2.equals("n")||temp2.equals("o")||temp2.equals("p")||temp2.equals("q")||temp2.equals("r")||temp2.equals("s")||temp2.equals("t")||temp2.equals("u")||temp2.equals("v")||temp2.equals("w")||temp2.equals("x")||temp2.equals("y")||temp2.equals("z")||
	            				temp2.equals("0")||temp2.equals("1")||temp2.equals("2")||temp2.equals("3")||temp2.equals("4")||temp2.equals("5")||temp2.equals("6")||temp2.equals("7")||temp2.equals("8")||temp2.equals("9")
		           		) {
		           			a.add(temp1);
		           		}else if(k<=10){
		           			temp2 = greeter.Modify(temp1);
		           			a.add(temp1);
	            			correct = false;
	            		}else {
	            			a.add(temp1);
	            			correct=true;
		           		}
		           		if(i==test.length()-2) {
		           			a.add(temp2);
		           		}
	            	}
	            	for(int i =0; i < a.size()-2; i++) {
	            		if(correct==true) {
	            			temp1 = a.get(i);
	            			temp2 = a.get(i+1);
	            			temp3 = a.get(i+2);
	            		}else {
	            			temp1 = temp2;
	            			temp2 = temp3;
	            			temp3 = a.get(i+2);
	            		}
	            		int k = 0;
	            		if(temp1!=","&& temp1!="¡C"&& temp2!=","&& temp2 !="¡C"&& temp1!="!"&& temp1!="?"&& temp2!="!"&&temp2 !="?"&& temp3!=","&& temp3!="¡C"&& temp3!="!"&& temp3 !="?"&&
	            				temp1!="A"&&temp1!="B"&&temp1!="c"&&temp1!="D"&&temp1!="E"&&temp1!="F"&&temp1!="G"&&temp1!="H"&&temp1!="I"&&temp1!="J"&&temp1!="K"&&temp1!="L"&&temp1!="M"&&
		            			temp1!="N"&&temp1!="O"&&temp1!="P"&&temp1!="Q"&&temp1!="R"&&temp1!="S"&&temp1!="T"&&temp1!="U"&&temp1!="V"&&temp1!="W"&&temp1!="X"&&temp1!="Y"&&temp1!="Z"&&
		            			temp1!="a"&&temp1!="b"&&temp1!="c"&&temp1!="d"&&temp1!="e"&&temp1!="f"&&temp1!="g"&&temp1!="h"&&temp1!="i"&&temp1!="j"&&temp1!="k"&&temp1!="l"&&temp1!="m"&&
		            			temp1!="n"&&temp1!="o"&&temp1!="p"&&temp1!="q"&&temp1!="r"&&temp1!="s"&&temp1!="t"&&temp1!="u"&&temp1!="v"&&temp1!="w"&&temp1!="x"&&temp1!="y"&&temp1!="z"&&
		            			temp2!="A"&&temp2!="B"&&temp2!="c"&&temp2!="D"&&temp2!="E"&&temp2!="F"&&temp2!="G"&&temp2!="H"&&temp2!="I"&&temp2!="J"&&temp2!="K"&&temp2!="L"&&temp2!="M"&&
		            			temp2!="N"&&temp2!="O"&&temp2!="P"&&temp2!="Q"&&temp2!="R"&&temp2!="S"&&temp2!="T"&&temp2!="U"&&temp2!="V"&&temp2!="W"&&temp2!="X"&&temp2!="Y"&&temp2!="Z"&&
		            			temp2!="a"&&temp2!="b"&&temp2!="c"&&temp2!="d"&&temp2!="e"&&temp2!="f"&&temp2!="g"&&temp2!="h"&&temp2!="i"&&temp2!="j"&&temp2!="k"&&temp2!="l"&&temp2!="m"&&
		            			temp2!="n"&&temp2!="o"&&temp2!="p"&&temp2!="q"&&temp2!="r"&&temp2!="s"&&temp2!="t"&&temp2!="u"&&temp2!="v"&&temp2!="w"&&temp2!="x"&&temp2!="y"&&temp2!="z"&&
		            			temp3!="A"&&temp3!="B"&&temp3!="c"&&temp3!="D"&&temp3!="E"&&temp3!="F"&&temp3!="G"&&temp3!="H"&&temp3!="I"&&temp3!="J"&&temp3!="K"&&temp3!="L"&&temp3!="M"&&
		            			temp3!="N"&&temp3!="O"&&temp3!="P"&&temp3!="Q"&&temp3!="R"&&temp3!="S"&&temp3!="T"&&temp3!="U"&&temp3!="V"&&temp3!="W"&&temp3!="X"&&temp3!="Y"&&temp3!="Z"&&
		            			temp3!="a"&&temp3!="b"&&temp3!="c"&&temp3!="d"&&temp3!="e"&&temp3!="f"&&temp3!="g"&&temp3!="h"&&temp3!="i"&&temp3!="j"&&temp3!="k"&&temp3!="l"&&temp3!="m"&&
		            			temp3!="n"&&temp3!="o"&&temp3!="p"&&temp3!="q"&&temp3!="r"&&temp3!="s"&&temp3!="t"&&temp3!="u"&&temp3!="v"&&temp3!="w"&&temp3!="x"&&temp3!="y"&&temp3!="z"&&
		            			temp1!="0"&&temp1!="1"&&temp1!="2"&&temp1!="3"&&temp1!="4"&&temp1!="5"&&temp1!="6"&&temp1!="7"&&temp1!="8"&&temp1!="9"&&
		            			temp2!="0"&&temp2!="1"&&temp2!="2"&&temp2!="3"&&temp2!="4"&&temp2!="5"&&temp2!="6"&&temp2!="7"&&temp2!="8"&&temp2!="9"&&
		            			temp3!="0"&&temp3!="1"&&temp3!="2"&&temp3!="3"&&temp3!="4"&&temp3!="5"&&temp3!="6"&&temp3!="7"&&temp3!="8"&&temp3!="9"
	            		) {
	            			try {
	            				k = greeter.get3Time(temp1, temp2, temp3);
	            			}catch(Exception e){
	            				k = 0;
	            			}
	            		}      			            		
	            		if(temp1.equals("¡A") || temp1.equals("¡C") || temp1.equals("!") || temp1.equals("?") ||
		           				temp1.equals("A")||temp1.equals("B")||temp1.equals("C")||temp1.equals("D")||temp1.equals("E")||temp1.equals("F")||temp1.equals("G")||temp1.equals("H")||temp1.equals("I")||temp1.equals("J")||temp1.equals("K")||temp1.equals("L")||temp1.equals("M")||
	            				temp1.equals("N")||temp1.equals("O")||temp1.equals("P")||temp1.equals("Q")||temp1.equals("R")||temp1.equals("S")||temp1.equals("T")||temp1.equals("U")||temp1.equals("V")||temp1.equals("W")||temp1.equals("X")||temp1.equals("Y")||temp1.equals("Z")||
	            				temp1.equals("a")||temp1.equals("b")||temp1.equals("c")||temp1.equals("d")||temp1.equals("e")||temp1.equals("f")||temp1.equals("g")||temp1.equals("h")||temp1.equals("i")||temp1.equals("j")||temp1.equals("k")||temp1.equals("l")||temp1.equals("m")||
	            				temp1.equals("n")||temp1.equals("o")||temp1.equals("p")||temp1.equals("q")||temp1.equals("r")||temp1.equals("s")||temp1.equals("t")||temp1.equals("u")||temp1.equals("v")||temp1.equals("w")||temp1.equals("x")||temp1.equals("y")||temp1.equals("z")||
	            				temp1.equals("0")||temp1.equals("1")||temp1.equals("2")||temp1.equals("3")||temp1.equals("4")||temp1.equals("5")||temp1.equals("6")||temp1.equals("7")||temp1.equals("8")||temp1.equals("9")
	            		) {
	            			if(temp2.equals("¡A")||temp2.equals("¡C")||temp2.equals("!")||temp2.equals("?")||
			           				temp2.equals("A")||temp2.equals("B")||temp2.equals("C")||temp2.equals("D")||temp2.equals("E")||temp2.equals("F")||temp2.equals("G")||temp2.equals("H")||temp2.equals("I")||temp2.equals("J")||temp2.equals("K")||temp2.equals("L")||temp2.equals("M")||
		            				temp2.equals("N")||temp2.equals("O")||temp2.equals("P")||temp2.equals("Q")||temp2.equals("R")||temp2.equals("S")||temp2.equals("T")||temp2.equals("U")||temp2.equals("V")||temp2.equals("W")||temp2.equals("X")||temp2.equals("Y")||temp2.equals("Z")||
		            				temp2.equals("a")||temp2.equals("b")||temp2.equals("c")||temp2.equals("d")||temp2.equals("e")||temp2.equals("f")||temp2.equals("g")||temp2.equals("h")||temp2.equals("i")||temp2.equals("j")||temp2.equals("k")||temp2.equals("l")||temp2.equals("m")||
		            				temp2.equals("n")||temp2.equals("o")||temp2.equals("p")||temp2.equals("q")||temp2.equals("r")||temp2.equals("s")||temp2.equals("t")||temp2.equals("u")||temp2.equals("v")||temp2.equals("w")||temp2.equals("x")||temp2.equals("y")||temp2.equals("z")||
		            				temp2.equals("0")||temp2.equals("1")||temp2.equals("2")||temp2.equals("3")||temp2.equals("4")||temp2.equals("5")||temp2.equals("6")||temp2.equals("7")||temp2.equals("8")||temp2.equals("9")
		            		) {
	            				b.add(temp2);
	            			}else if(temp3.equals("¡A")||temp3.equals("¡C")||temp3.equals("!")||temp3.equals("?")||
			           				temp3.equals("A")||temp3.equals("B")||temp3.equals("C")||temp3.equals("D")||temp3.equals("E")||temp3.equals("F")||temp3.equals("G")||temp3.equals("H")||temp3.equals("I")||temp3.equals("J")||temp3.equals("K")||temp3.equals("L")||temp3.equals("M")||
		            				temp3.equals("N")||temp3.equals("O")||temp3.equals("P")||temp3.equals("Q")||temp3.equals("R")||temp3.equals("S")||temp3.equals("T")||temp3.equals("U")||temp3.equals("V")||temp3.equals("W")||temp3.equals("X")||temp3.equals("Y")||temp3.equals("Z")||
		            				temp3.equals("a")||temp3.equals("b")||temp3.equals("c")||temp3.equals("d")||temp3.equals("e")||temp3.equals("f")||temp3.equals("g")||temp3.equals("h")||temp3.equals("i")||temp3.equals("j")||temp3.equals("k")||temp3.equals("l")||temp3.equals("m")||
		            				temp3.equals("n")||temp3.equals("o")||temp3.equals("p")||temp3.equals("q")||temp3.equals("r")||temp3.equals("s")||temp3.equals("t")||temp3.equals("u")||temp3.equals("v")||temp3.equals("w")||temp3.equals("x")||temp3.equals("y")||temp3.equals("z")||
		            				temp3.equals("0")||temp3.equals("1")||temp3.equals("2")||temp3.equals("3")||temp3.equals("4")||temp3.equals("5")||temp3.equals("6")||temp3.equals("7")||temp3.equals("8")||temp3.equals("9")
		            		){
	            					b.add(temp2);
		           					b.add(temp3);
		           			}
	            			correct=true;
	            		}else if(temp2.equals("¡A")||temp2.equals("¡C")||temp2.equals("!")||temp2.equals("?")||
		           				temp2.equals("A")||temp2.equals("B")||temp2.equals("C")||temp2.equals("D")||temp2.equals("E")||temp2.equals("F")||temp2.equals("G")||temp2.equals("H")||temp2.equals("I")||temp2.equals("J")||temp2.equals("K")||temp2.equals("L")||temp2.equals("M")||
	            				temp2.equals("N")||temp2.equals("O")||temp2.equals("P")||temp2.equals("Q")||temp2.equals("R")||temp2.equals("S")||temp2.equals("T")||temp2.equals("U")||temp2.equals("V")||temp2.equals("W")||temp2.equals("X")||temp2.equals("Y")||temp2.equals("Z")||
	            				temp2.equals("a")||temp2.equals("b")||temp2.equals("c")||temp2.equals("d")||temp2.equals("e")||temp2.equals("f")||temp2.equals("g")||temp2.equals("h")||temp2.equals("i")||temp2.equals("j")||temp2.equals("k")||temp2.equals("l")||temp2.equals("m")||
	            				temp2.equals("n")||temp2.equals("o")||temp2.equals("p")||temp2.equals("q")||temp2.equals("r")||temp2.equals("s")||temp2.equals("t")||temp2.equals("u")||temp2.equals("v")||temp2.equals("w")||temp2.equals("x")||temp2.equals("y")||temp2.equals("z")||
	            				temp2.equals("0")||temp2.equals("1")||temp2.equals("2")||temp2.equals("3")||temp2.equals("4")||temp2.equals("5")||temp2.equals("6")||temp2.equals("7")||temp2.equals("8")||temp2.equals("9")	            				
	            		){
	            			correct=true;
	            		}else if(temp3.equals("¡A")||temp3.equals("¡C")||temp3.equals("!")||temp3.equals("?")||
		           				temp3.equals("A")||temp3.equals("B")||temp3.equals("C")||temp3.equals("D")||temp3.equals("E")||temp3.equals("F")||temp3.equals("G")||temp3.equals("H")||temp3.equals("I")||temp3.equals("J")||temp3.equals("K")||temp3.equals("L")||temp3.equals("M")||
	            				temp3.equals("N")||temp3.equals("O")||temp3.equals("P")||temp3.equals("Q")||temp3.equals("R")||temp3.equals("S")||temp3.equals("T")||temp3.equals("U")||temp3.equals("V")||temp3.equals("W")||temp3.equals("X")||temp3.equals("Y")||temp3.equals("Z")||
	            				temp3.equals("a")||temp3.equals("b")||temp3.equals("c")||temp3.equals("d")||temp3.equals("e")||temp3.equals("f")||temp3.equals("g")||temp3.equals("h")||temp3.equals("i")||temp3.equals("j")||temp3.equals("k")||temp3.equals("l")||temp3.equals("m")||
	            				temp3.equals("n")||temp3.equals("o")||temp3.equals("p")||temp3.equals("q")||temp3.equals("r")||temp3.equals("s")||temp3.equals("t")||temp3.equals("u")||temp3.equals("v")||temp3.equals("w")||temp3.equals("x")||temp3.equals("y")||temp3.equals("z")||
	            				temp3.equals("0")||temp3.equals("1")||temp3.equals("2")||temp3.equals("3")||temp3.equals("4")||temp3.equals("5")||temp3.equals("6")||temp3.equals("7")||temp3.equals("8")||temp3.equals("9")
	            		){
	            			b.add(temp1);
	            			b.add(temp2);
	            			b.add(temp3);
	            			correct=true;
	            		}else if(k<=2){
	            			temp2 = greeter.ModifyMidWord(temp1,temp3);
	            			b.add(temp1);
	            			correct = false;
	            		}else {
	            			b.add(temp1);
	            			correct=true;
	            		}				
	            	}
	            	
	            	for(int j = 0; j < a.size(); j++) {   
	            		System.out.print(a.get(j));
	            		//out.write(b.get(j));
	            	}
	            	//out.write("\r\n");
    				System.out.println();
	            }
	            //out.flush();
            	//out.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
			
        }
	}
}