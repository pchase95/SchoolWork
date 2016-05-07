<?php
require_once "dblogin.php";
require_once "../Utilities/functions.php";

error_reporting(E_ALL);
ini_set('display_errors', 1);

session_start();

$mysqli = new mysqli($db_hostname,$db_username,$db_password,$db_database);
if ($mysqli->connect_error)
{
  die("Connection failed: " . $mysqli->connect_error);
}

header("Access-Control-Allow-Origin: *");

$cmd = getValue("cmd");
if ($cmd == "films")
{
  $response = listFilms();

  header('Content-type: application/json');
  echo json_encode($response);
}
else if ($cmd == "actors")
{
  $response = listActors(getValue("film_id"));

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
          <h2>List All Films</h2>

          <h3>Parameters:</h3>
          <ul>
            <li>cmd=films</li>

          </ul>

          <h3>Returns:</h3>
          <p>All films</p>

          <h3>Example:</h3>
          <p><a href='FilmsAndActors.php?cmd=films'>?cmd=films</a></p>
          <pre>
            [ ['1','ACADEMY DINOSAUR'],['2','ACE GOLDFINGER'],['3','ADAPTATION HOLES'] ... ]
          </pre>
        </li>

        <li>
          <h2>List All Actors</h2>

          <h3>Parameters:</h3>
          <ul>
            <li>cmd=actors</li>
            <li>film_id=id (optional)</li>
          </ul>

          <h3>Returns:</h3>
          <p>All actors in specified film.  If the film is not specified, all actors are returned.</p>

          <h3>Example:</h3>
          <p><a href='FilmsAndActors.php?cmd=actors&film_id=1'>?cmd=actors&film_id=1</a></p>
          <pre>
            [['7','GRACE','MOSTEL'],['47','JULIA','BARRYMORE'] ... ]
          </pre>
        </li>

      </ul>
    </body>
  </html>
  ";
}

function listFilms()
{
  global $mysqli;
  $response = [];
  $query = "SELECT film_id, title FROM film";
  $res = $mysqli->query($query) or die(mysqli_error($mysqli));
  while($row = $res->fetch_assoc())
  {
    $response[] = $row;
  }
  return $response;
}

function listActors($film_id)
{
  global $mysqli;
  $response = [];
  if ($film_id == "")
  {
    $query = "SELECT actor_id, first_name, last_name FROM actor";
    $res = $mysqli->query($query) or die(mysqli_error($mysqli));
    while($row = $res->fetch_assoc())
    {
      $response[] = $row;
    }
  }
  else
  {
    $query = "SELECT actor.actor_id, first_name, last_name FROM actor INNER JOIN film_actor WHERE film_actor.actor_id = actor.actor_id AND film_actor.film_id = ?";
    $stmt = $mysqli->stmt_init();
    $stmt->prepare($query) or die(mysqli_error($mysqli));
    $stmt->bind_param('i', $film_id);
    $stmt->execute();
    $res = $stmt->get_result();
    while ($row = $res->fetch_assoc())
    {
        $response[] = $row;
    }
    $stmt->close();
  }
  return $response;
}

$mysqli->close();
?>
