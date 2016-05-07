<?php
require_once "../Utilities/functions.php";

error_reporting(E_ALL);
ini_set('display_errors', 1);

session_start();
header("Access-Control-Allow-Origin: *");

$cmd = getValue("cmd");
if ($cmd == "play")
{
  $response = play();
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
          <h2>A game that asks you to guess the lucky color.</h2>

          <h3>Parameters:</h3>
          <ul>
            <li>cmd=play</li>
            <li>guess[]=color&amp;guess[]=color&amp;...</li>
          </ul>

          <h3>Returns:</h3>
          <p>Returns a string telling you if you guessed the lucky color.</p>

          <h3>Example:</h3>
          <p><a href='luckyColor.php?cmd=play&guess[]=red&guess[]=green'>?cmd=play&guess[]=red&guess[]=green</a></p>
          <pre>
            ['Try again!']
          </pre>
        </li>
      </ul>
    </body>
  </html>
  ";
}

function play()
{
  // handle command...
  $response = "Try again!";
  $guesses = getValue("guess");
  for ($i = 0; $i < count($guesses); $i++)
  {
    if ($guesses[$i] == "pink")
    {
      $response = "You win!";
    }
  }
  return $response;
}
?>
