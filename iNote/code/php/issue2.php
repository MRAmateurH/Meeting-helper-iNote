<?php

define('db_host','localhost');
define('db_user','6teen');
define('db_pass','tkuim6teen');
define('db_name','inote');
$conn=new mysqli(db_host,db_user,db_pass,db_name);
if(mysqli_connect_errno()){
	die('no'.mysqli_connect_error());
}
$code=$_GET['code'];

$stmt=$conn->prepare("SELECT issue1,issue2,issue3,issue4,issue5 FROM issue WHERE meeting_id=$code;");
$stmt->execute();
$stmt->bind_result($issue1,$issue2,$issue3,$issue4,$issue5);
$product=array();
while($stmt->fetch()){
	$temp=array();
	$temp['issue1']=$issue1;
	$temp['issue2']=$issue2;
	$temp['issue3']=$issue3;
	$temp['issue4']=$issue4;
	$temp['issue5']=$issue5;
	array_push($product,$temp);
}
echo json_encode($product);