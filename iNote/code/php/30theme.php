<?php

define('db_host','localhost');
define('db_user','6teen');
define('db_pass','tkuim6teen');
define('db_name','inote');
$conn=new mysqli(db_host,db_user,db_pass,db_name);
if(mysqli_connect_errno()){
	die('no'.mysqli_connect_error());
}
$phone=$_GET['phone'];

$stmt=$conn->prepare("SELECT theme FROM issue where phone='$phone'");
$stmt->execute();
$stmt->bind_result($theme);
$product=array();
while($stmt->fetch()){
	$temp=array();
	$temp['theme']=$theme;
	array_push($product,$temp);
}
echo json_encode($product);
