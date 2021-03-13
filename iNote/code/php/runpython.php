<?php
$code=$_GET['code'];
passthru("python C:\Users\Administrator\DBdata\Execute\summaryTodb.py ");
passthru("python C:\Users\Administrator\DBdata\py.file\wavTodb.py {$code}");
?>