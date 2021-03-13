<?php

$conn=new mysqli('localhost','6teen','tkuim6teen','inote');
if(mysqli_connect_errno()){
 die('no'.mysqli_connect_error());
}
$phone=$_GET['phone'];
$stmt=$conn->prepare("SELECT path FROM photo where phone='$phone';");
$stmt->execute();
$stmt->bind_result($path);
$product=array();
while($stmt->fetch()){
 $temp=array();
 $temp['path']=$path;
 array_push($product,$temp);
}
echo json_encode($product);
?>
 