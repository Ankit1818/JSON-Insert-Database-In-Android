<?php



include('dbConnect.php');


$username = $_POST['name'];

 
$email = $_POST['email'];
 
 


if($username=="" && $email=="")


{
       

echo '0';


}



else

{ 
  

$sql = "INSERT INTO test3 (name,email) VALUES ('$username','$email')";

//echo $sql;
    $ex=mysqli_query($con,$sql);

    


}

 


?>