export function MergedPlayers() {
  const t20players = ['First Player', 'Second player', 'Third player']
  const ranjiTrophyPlayers = ['Forth player', 'Fifth player', 'Sixth player']
  const players = [...t20players, ...ranjiTrophyPlayers]

  return (
    <div className="merged">
      <h2> List of Merged Players </h2>
      <ul>
        {players.map((player) => (
          <li key={player}> {player}</li>
        ))}
      </ul>
    </div>
  )

}
