<?php
$file = "ivt.txt";
//链接本地数据库
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
//接受用户名和密码
    $meeting = $_POST['meeting'];
    
file_put_contents($file, "邀請碼：".$meeting."\n",FILE_APPEND);
//从users表查询数据,where子句查询，和上一篇文章的方式一样
    $sql = "select * from meetingdetails where meeting_id='$meeting'";
//建立链接
    $result = mysqli_query($link, $sql);
//获取返回集
    $num = mysqli_num_rows($result);
   file_put_contents($file, "查询值：".$num."\n",FILE_APPEND);
//创建空数组
    $response = array();
//如果返回集大于0，证明数据库里有这个数据
    if ($num > 0) {
        //添加登陆成功的标志
        $response["success"] = 1;
    } else {
        $response["success"] = 0;
    }
    echo json_encode($response);
	//$meetingdetails=mysqli_fetch_assoc($result);
//以json的形式返回给客户端
    mysqli_close($link);
//关闭数据库
}?>