<?php
require "init.php";
$user_name=$_POST["UserName"];
$user_pass=$_POST["Password"];


$sql_query="select name from customer where Username like '$user_name' and Password like '$user_pass';";

$result= mysqli_query($con,$sql_query);

if(mysqli_num_rows($result)>0)
{
$row = mysqli_fetch_assoc($result);
$name = $row["name"];
echo "Successful login ".$name;
}
else
{
echo "Unsucessful Login....".mysql_error();
}

?>