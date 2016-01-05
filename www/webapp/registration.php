<?php
require "init.php";

//$name="Shiva";
//$conno=7774896860 ;
//$mailid="shivanjali.ranashing";
//$username="Shiva";
//$password="Shiva";
//$sql_query="insert into customer(Name,ConNo,EmailId,Username,Password)values('$name','$conno','$mailid','$username','$password')";

$name=$_POST["Name"];
$connostr=$_POST["ConNo"];
$conno=(int) $connostr;
$mailid=$_POST["Maildid"];
$username=$_POST["Username"];
$password=$_POST["Password"];
$sql_query="insert into customer(Name,ConNo,EmailId,Username,Password)values('$name','$conno','$mailid','$username','$password')";
if(mysqli_query($con,$sql_query))
{
	echo "<h3>Donee</h3>";
}
else
{
	echo"<h3>Not Done</h3>".mysql_error($con);
}

?>