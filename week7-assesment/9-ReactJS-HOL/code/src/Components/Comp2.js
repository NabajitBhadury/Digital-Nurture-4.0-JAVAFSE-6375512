import { EvenPlayers } from "./Even";
import { MergedPlayers } from "./Merged";
import { OddPlayers } from "./Odd";

export default function Comp2({ players }) {
  return (
    <div className="comp2">
      <EvenPlayers players={players} />
      <OddPlayers players={players} />
      <MergedPlayers />
    </div>
  )
}
