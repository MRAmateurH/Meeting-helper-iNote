<?php 
$hostname_localhost ="127.0.0.1";
$username_localhost ="6teen";
$password_localhost ="tkuim6teen";
$dbname="inote"; 
$conn = mysqli_connect ($hostname_localhost,$username_localhost,$password_localhost,$dbname);
    if($_SERVER['REQUEST_METHOD'] == 'POST') {
        $ImageData = $_POST['image'];
        $ImageName = $_POST['name'];
		$phone=$_GET['phone'];

        $ImagePath = "uploads/$ImageName";

        $insertSQL = "update photo set name='$ImageName',path='$ImagePath'where phone='$phone'";

        if(mysqli_query($conn, $insertSQL)){
            file_put_contents($ImagePath,base64_decode($ImageData));
			
        }

        mysqli_close($conn);
    } else {
        
    }
 ?>