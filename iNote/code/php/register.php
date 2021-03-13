<?php

$file = "log.txt";
$hostname_localhost ="127.0.0.1";
$username_localhost ="6teen";
$password_localhost ="tkuim6teen";
$dbname="inote"; 
$link =  mysqli_connect ($hostname_localhost,$username_localhost,$password_localhost,$dbname);

//分为两种状态，链接数据库失败，封装json发送给Android端
 if(!$link){
    $response = array();
    //用3来代表数据库链接失败
    $response["success"] = 3;
   //输出给前端
    echo json_encode($response);
}else {
    //接受post的用户名和密码
	$name=$_POST['name'];
    $phone = $_POST['phone'];
    $password = $_POST['password'];
	

  //向日志文件写日志
    file_put_contents($file, "用戶請求註冊：".$name."電話：".$phone."密码：".$password."\n",FILE_APPEND);
//向users表添加数据（users表是你建立的数据库下的表）
    $sql = "insert into user (name,phone,password) values('$name','$phone','$password')";
//建立链接
    $result = mysqli_query($link, $sql);
    if ($sql) {
        //添加注册成功的标志
        $response["success"] = 1;
		
    } else {
        $response["success"] = 0;
    }
    echo json_encode($response);

    mysqli_close($link);
//关闭数据库
}
?>