import React from "react";
import players1 from "../../players.json"; 

export default function PlayerDetail({ close, i, addPlayer, selectedPlayers }) {
  const [players] = React.useState(players1); 

  
  if (i === null || i >= players.length || i < 0) return null;

  const player = players[i];
  const nameTest = player.name.split(" ").join("-"); 


  const cardStyle = {
    position: "fixed",
    left: "50%",
    transform: "translateX(-50%)",
    padding: "20px",
    width: "500px",
    top: "20%",
    backgroundColor: "white", 
    boxShadow: "0px 0px 10px rgba(0,0,0,0.1)", 
    zIndex: 1000 
  };

  return (
    //从父组件获得数据，详细展示球员信息
    <div className="card outlined mt-0" data-testid={`player-${nameTest}-details`} style={cardStyle}>
      <h1 className="card-title" style={{ textAlign: "center" }}>Player Detail</h1>
      <p>
        <strong>Name:</strong>{" "}
        <span data-testid={`player-detail-${nameTest}-name`}>
          {player.name}
        </span>
      </p>
      <p>
        <strong>Type:</strong>{" "}
        <span data-testid={`player-detail-${nameTest}-type`}>
          {player.type}
        </span>
      </p>
      <p>
        <strong>Batting:</strong>{" "}
        <span data-testid={`player-detail-${nameTest}-batting`}>
          {player.battingSkill}
        </span>
      </p>
      <p>
        <strong>Bowling:</strong>{" "}
        <span data-testid={`player-detail-${nameTest}-bowling`}>
          {player.bowlingSkill}
        </span>
      </p>
      <button
        disabled={selectedPlayers.some(p => p.name === player.name && p.type === player.type)}
        onClick={() => addPlayer(i)}
        data-testid={`player-detail-${nameTest}-add`}
      >
        Select
      </button>
      <button onClick={close} className="danger" data-testid={`player-detail-${nameTest}-close`}>
        Close
      </button>
    </div>
  );
}