<?php
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
	$code=$_POST['code'];
    $sql = "INSERT INTO voice (meeting_id) values('$code')";
    $result = mysqli_query($link, $sql);
	$num = mysqli_num_rows($result);
    if (num>0) {
        //添加注册成功的标志
        $response["success"] = 1;
    } else {
        $response["success"] = 0;
    }
    echo json_encode($response);
//以json的形式返回给客户端
   mysqli_close($link);}
//关闭数据库

?>