<?php

$con=mysqli_connect("localhost","6teen","tkuim6teen","inote");
$phone=$_GET['phone'];
$query="SELECT name FROM user WHERE phone='$phone'";

$result = mysqli_query($con, $query);
while(($row = mysqli_fetch_assoc($result)) == true){
	$data[]=$row;
}
echo json_encode($data);
	
?>