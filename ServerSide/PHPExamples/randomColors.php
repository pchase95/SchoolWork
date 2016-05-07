<?php
require_once "../Utilities/functions.php";

error_reporting(E_ALL);
ini_set('display_errors', 1);

session_start();
header("Access-Control-Allow-Origin: *");

$cmd = getValue("cmd");
if ($cmd == "colors")
{
  $response = colors();
  header('Content-type: application/json');
  echo json_encode($response);
}
else // list all supported commands
{
  echo
  "
  <html>
    <body>
      <h1>API</h1>
      <ul>
        <li>
          <h2>Generates a specified number of random colors</h2>

          <h3>Parameters:</h3>
          <ul>
            <li>cmd=colors</li>
            <li>num=num_of_colors</li>
          </ul>

          <h3>Returns:</h3>
          <p>An array of random colors</p>

          <h3>Example:</h3>
          <p><a href='randomColors.php?cmd=colors&num=5'>?cmd=colors&num=5</a></p>
          <pre>
            ['tan','green','purple','grey']
          </pre>
        </li>
      </ul>
    </body>
  </html>
  ";
}

function colors()
{
  $response = [];
  $num = getValue("num");
  $colors = ["red", "green", "blue", "pink", "yellow", "orange",
    "cyan", "purple", "black", "white", "grey", "brown", "tan"];
  for ($i = 0; $i < $num; $i++)
  {
    $choice = rand(0, count($colors)-1);
    $response[] = $colors[$choice];
  }
  return $response;
}

?>
