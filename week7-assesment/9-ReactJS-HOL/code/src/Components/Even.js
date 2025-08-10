export function EvenPlayers({ players }) {
  const [, second, , fourth, , sixth] = players;
  return (
    <div className="even">
      <h2> List of Even Players </h2>
      <ul>
        <li> {second.name} {second.score}</li>
        <li> {fourth.name} {fourth.score}</li>
        <li> {sixth.name} {sixth.score}</li>
      </ul>
    </div>
  )
}
