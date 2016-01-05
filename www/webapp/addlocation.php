<?php
require "init.php";

//$source="William";
//$destination="Indian Street";
//$cabtype="Cab123";
//$date="12Dec";
//$time="12.00";
//$sql_query="insert into bookcab(Source,Destination,CabType,Date,Time)values('$source','$destination','$cabtype','$date','$time')";

$source=$_POST["Source"];
$destination=$_POST["Destination"];
$cabtype=$_POST["CabType"];
$date=$_POST["Date"];
$time=$_POST["Time"];
$sql_query="insert into bookcab(Source,Destination,CabType,Date,Time)values('$source','$destination','$cabtype','$date','$time')";
if(mysqli_query($con,$sql_query))
{
	echo "<h3>Cab is booked Successfully.....</h3>";
}
else
{
	echo"<h3>Cab is booked Successfully.....</h3>".mysql_error($con);
}

?>