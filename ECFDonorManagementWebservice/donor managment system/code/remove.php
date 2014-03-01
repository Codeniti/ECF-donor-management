<?php
$host="localhost";
$user="root";
$pass="root";
$con = mysql_connect("$host","$user","$pass");


if (!$con)
  {

echo "Error in DBConnect() = " . mysql_get_last_message();
  die('Could not connect: ' . mysql_error());

  }



mysql_select_db("ecf", $con);

$id=$_POST['id'];
$name=$_POST['fname'];

$sql="delete from donors where id='$id' and fname='$name'"; 


if (!mysql_query($sql,$con))
{
die('Error: ' . mysql_error());
}
header('Location:admin_page.php');
mysql_close($con)
?> 
