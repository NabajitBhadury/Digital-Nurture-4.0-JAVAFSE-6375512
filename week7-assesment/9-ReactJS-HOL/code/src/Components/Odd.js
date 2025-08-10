export function OddPlayers({ players }) {
  const [first, , third, , fifth] = players;
  return (
    <div className="even">
      <h2> List of Odd Players </h2>
      <ul>
        <li> {first.name} {first.score}</li>
        <li> {third.name} {third.score}</li>
        <li> {fifth.name} {fifth.score}</li>
      </ul>
    </div>
  )
}
