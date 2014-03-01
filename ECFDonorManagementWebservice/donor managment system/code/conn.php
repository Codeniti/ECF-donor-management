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

$sql="INSERT INTO donors (fname,lname,address,city,state,pcode,country,email,mob,dtype,amt) 
VALUES
('$_POST[fname]','$_POST[lname]','$_POST[address]','$_POST[city]','$_POST[state]','$_POST[pcode]','$_POST[country]','$_POST[email]','$_POST[mob]','$_POST[dtype]','$_POST[amt]')"; 


if (!mysql_query($sql,$con))
{
die('Error: ' . mysql_error());
}
header('Location:index.php');
mysql_close($con)
?> 
