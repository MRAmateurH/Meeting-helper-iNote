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
    
    $meeting_id = $_POST['meeting_id'];
	$phone=$_POST['phone'];
    $name= $_POST['name'];
	$theme=$_POST['theme'];
	$date=$_POST['date'];
    $sql = "insert into meetingdetails (phone,meeting_id,name,theme,date) values('$phone',' $meeting_id','$name','$theme','$date')";
//建立链接
    $result = mysqli_query($link, $sql);
    if ($sql) {
        //添加注册成功的标志
        $response["success"] = 1;
    } else {
        $response["success"] = 0;
    }
    echo json_encode($response);
//以json的形式返回给客户端
    mysqli_close($link);
//关闭数据库
}
?>