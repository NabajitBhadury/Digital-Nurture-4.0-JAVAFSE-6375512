
export default function Comp1({ players }) {
  return (
    <div className="comp1">
      <h2> List of Players </h2>
      <ul>
        {players.map((player) => (
          <li key={player.name}> {player.name} {player.score}</li>
        ))}
      </ul>
      <h2> List of players with scores below 70 </h2>
      <ul>
        {players.filter((player) => player.score < 70).map((player) => (
          <li key={player.name}> {player.name} {player.score}</li>
        ))}
      </ul>
    </div>
  )
}
