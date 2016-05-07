<?php
require_once "../Utilities/functions.php";

error_reporting(E_ALL);
ini_set('display_errors', 1);

session_start();
header("Access-Control-Allow-Origin: *");

$quote1['text'] = "People who think they know everything are a great annoyance to those of us who do.";
$quote1['author'] = "Isaac Asimov";
$quote2['text'] = "A woman's mind is cleaner than a man's: She changes it more often.";
$quote2['author'] = "Oliver Herford";
$quote3['text'] = "Do not take life too seriously. You will never get out of it alive.";
$quote3['author'] = "Elbert Hubbard";
$quotes = [$quote1, $quote2, $quote3];

$cmd = getValue("cmd");
if ($cmd == "quote")
{
  $response = quote();
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
          <h2>Generates a random quote</h2>

          <h3>Parameters:</h3>
          <ul>
            <li>cmd=quote</li>
          </ul>

          <h3>Returns:</h3>
          <p>A random quote</p>

          <h3>Example:</h3>
          <p><a href='quotes.php?cmd=quote'>?cmd=quote</a></p>
          <pre>
            {'text':'A womans mind is cleaner than a mans: She changes it more often.','author':'Oliver Herford'}
          </pre>
        </li>
      </ul>
    </body>
  </html>
  ";
}

function quote()
{
  global $quotes;
  $choice = rand(0, count($quotes)-1);
  $response = $quotes[$choice];
  return $response;
}

?>
