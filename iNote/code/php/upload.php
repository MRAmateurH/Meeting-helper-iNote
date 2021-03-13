<?php
 $con=mysqli_connect("127.0.0.1", "6teen", "tkuim6teen", "inote");
 $issue=$_GET['issue'];

	if($_SERVER['REQUEST_METHOD']=='POST'){
		$file_name = $_FILES['myFile']['name'];
		$file_size = $_FILES['myFile']['size'];
		$file_type = $_FILES['myFile']['type'];
		$temp_name = $_FILES['myFile']['tmp_name'];
		
		$location = "C:/Users/Administrator/DBdata/wav_file/";
		$file="C:/Users/Administrator/DBdata/wav_file/".$file_name;	
		move_uploaded_file($temp_name, $location.$file_name);
		echo "".$file_name;
		
		if (!mysqli_query($con,"update voice set name='$file_name',path='$file',issue='$issue' where voice_id=(select MAX(voice_id)from voice)")) {
						echo('Error:'.mysqli_error($con));
						}else{
							 
                            
                             shell_exec(" java -jar reco.jar ");
							 $con->close();}
                
	}else{
		echo "Error";
	}
	

?>