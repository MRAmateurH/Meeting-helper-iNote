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
$stmt=$conn->prepare("SELECT name FROM summary where meeting_id='$code'");
$stmt->execute();
$stmt->bind_result($name);
$product=array();
while($stmt->fetch()){
	$temp1=array();
	$temp=array();
	$temp1['name']=$name;
	if(file_exists($name)){
    $temp=file($name);//將整個檔案內容讀入到一個字串中; 
$temp = str_replace("\r\n","<br />",$temp);
	array_push($product,$temp);
	//$product[$temp];
	}
	
}
echo json_encode($product,JSON_FORCE_OBJECT);

?>