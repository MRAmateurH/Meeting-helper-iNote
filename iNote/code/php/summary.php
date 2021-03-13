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

$stmt=$conn->prepare("SELECT issue FROM summary where meeting_id='$code'");
$stmt->execute();
$stmt->bind_result($issue);
$product=array();
while($stmt->fetch()){
	$temp=array();
	$temp['issue']=$issue;
	array_push($product,$temp);
}
echo json_encode($product);
