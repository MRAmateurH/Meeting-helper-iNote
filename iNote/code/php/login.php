<?php
session_start();
$file = "log.txt";
$hostname_localhost ="127.0.0.1";
$username_localhost ="6teen";
$password_localhost ="tkuim6teen";
$dbname="inote"; 
$link =  mysqli_connect ($hostname_localhost,$username_localhost,$password_localhost,$dbname);
if(!$link){
  $response = array();
    $response["success"] = 3;
  echo json_encode($response);
}else {

    $phone = $_POST['phone'];
    $password = $_POST['password'];
    file_put_contents($file, "用户请求登录：".$phone."密码：".$password."\n",FILE_APPEND);

    $sql = "select * from user where phone='$phone' and password='$password'";

    $result = mysqli_query($link, $sql);

    
    $num = mysqli_num_rows($result);
    file_put_contents($file, "查询值：".$num."\n",FILE_APPEND);

    $response = array();

    if ($num > 0) {
        //添加登陆成功的标志
        $response["success"] = 1;
    } else {
        $response["success"] = 0;
    }
    echo json_encode($response);


$user=mysqli_fetch_assoc($result);



 
    mysqli_close($link);
	
//关闭数据库
}?>