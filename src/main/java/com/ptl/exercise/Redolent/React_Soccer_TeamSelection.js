import React from "react";
import PlayerDetail from "../../player-info";
import playersList from "../../players.json";

export default function TeamSelection() {
  const [players, setPlayers] = React.useState(playersList);
  const [selectedPlayers, setSelectedPlayers] = React.useState([]);
  const [showPlayerDetail, setShowPlayerDetail] = React.useState(false);
  const [idx, setIdx] = React.useState(null);
  const [welcome, setWelcome] = React.useState(true);
  const [noBat, setNoBat] = React.useState(0);
  const [noBowl, setNoBowl] = React.useState(0);
  const [noAR, setNoAR] = React.useState(0);
  const [noWK, setNoWK] = React.useState(0);

  const addPlayer = (index) => {
    const player = players[index];

    //test case检查所有球员是否大于等于11
    if (selectedPlayers.length >= 11) {
      alert("Only 11 players are allowed in a team");
      return;
    }

    const type = player.type;
    //检查batsman的个数不能大于6
    if (type === "Batsman") {
      const batsmenCount = selectedPlayers.filter(p => p.type === "Batsman").length;
      if (batsmenCount >= 6) {
        alert("Batsman can not be more than 6");
        return;
      }
    }
    //检查allrounder的个数不能大于4个
    if (type === "AllRounder") {
      const allRoundersCount = selectedPlayers.filter(p => p.type === "AllRounder").length;
      if (allRoundersCount >= 4) {
        alert("All Rounders can not be more than 4");
        return;
      }
    }
    //检查bowler 个数不能大于6个
    if (type === "Bowler") {
      const bowlersCount = selectedPlayers.filter(p => p.type === "Bowler").length;
      if (bowlersCount >= 6) {
        alert("Bowlers can not be more than 6");
        return;
      }
    }
    //检查wicketkeeper个数不能超过1个
    if (type === "WicketKeeper") {
        const wicketKeeperCount = selectedPlayers.filter(p => p.type === "WicketKeeper").length;
        if (wicketKeeperCount >= 1) {
            alert("Only 1 Wicket Keeper allowed"); // Corrected alert message based on common cricket rules
            return;
        }
    }
    //新增一个player到 selectedPlayers列表
    setSelectedPlayers([...selectedPlayers, player]);
    setWelcome(false);
    //增加对应type的球员数量+1
    if (type === "Batsman") setNoBat(noBat + 1);
    if (type === "Bowler") setNoBowl(noBowl + 1);
    if (type === "AllRounder") setNoAR(noAR + 1);
    if (type === "WicketKeeper") setNoWK(noWK + 1);
  };

  const removePlayer = (index) => {
    const player = selectedPlayers[index];
    const newList = [...selectedPlayers];
    newList.splice(index, 1);
    setSelectedPlayers(newList);
    //减少对应type的球员数量一个
    const type = player.type;
    if (type === "Batsman") setNoBat(noBat - 1);
    if (type === "Bowler") setNoBowl(noBowl - 1);
    if (type === "AllRounder") setNoAR(noAR - 1);
    if (type === "WicketKeeper") setNoWK(noWK - 1);
  };

  const showPlayerDetailsCard = (i) => {
    setIdx(i);
    setShowPlayerDetail(true);
  };

  const closeCard = () => {
    setShowPlayerDetail(false);
    setIdx(null);
  };

  return (
    <div className="mt-50 layout-column justify-content-center align-items-center">
      {idx !== null && showPlayerDetail && (
        <PlayerDetail
          close={() => closeCard()}
          i={idx}
          addPlayer={(idx) => addPlayer(idx)}
          selectedPlayers={selectedPlayers}
        />
      )}

      <div className="card outlined mt-0"
        style={{
          width: "50%",
          marginRight: "10px",
          overflow: "scroll",
          height: "80vh",
        }}
      >
        <div className="card-text">
          <h4 style={{ textAlign: "center" }}>Available Players</h4>
          <table>
            <thead>
              <tr>
                <th data-testid="available-players-name">Name</th>
                <th>Role</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {welcome && (
                <tr data-testid="selection-rules" colSpan="3" className="card pb-20">
                  <td>
                    <p data-testid="close-welcome" style={{ textAlign: "right" }} onClick={() => setWelcome(false)}>X</p>
                    <h3 style={{ textAlign: "center" }}>
                      <strong>Welcome to Team Selection</strong>
                    </h3>
                    <p>11 players are required in a team</p>
                    <p>3-6 batsmen and bowlers are allowed in a team</p>
                    <p>Only 1 Wicket Keeper required in a team</p>
                    <p>1-4 All Rounders are allowed in a team</p>
                  </td>
                </tr>
              )}
              {players.map((player, i) => {
                const nameTest = player.name.split(" ").join("-");
                return (
                    //遍历展示player的 名字跟种类
                  <tr key={i} data-testid={`available-${nameTest}-row`}>
                    <td data-testid={`available-${nameTest}-name`} onClick={() => showPlayerDetailsCard(i)}>
                      {player.name}
                    </td>
                    <td data-testid={`available-${nameTest}-type`} onClick={() => showPlayerDetailsCard(i)}>
                      {player.type}
                    </td>
                    <td>
                      <button
                        data-testid={`available-${nameTest}-select`}
                        onClick={() => addPlayer(i)}
                        disabled={selectedPlayers.some(p => p.name === player.name && p.type === player.type)}
                        className="btn primary text"
                      >
                        Select
                      </button>
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      </div>

      <div className="card outlined mt-0"
        style={{
          width: "50%",
          overflow: "scroll",
          height: "80vh",
        }}
      >
        <div className="card-text">
          <h4 style={{ textAlign: "center" }}>Selected Players</h4>
          <table>
            <thead>
              <tr>
                <th>Name</th>
                <th>Role</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody data-testid="selected-players-table-body">
                
              {selectedPlayers.map((player, index) => {
                const nameTest = player.name.split(" ").join("-");
                return (
                    //遍历并删除选中的player
                  <tr key={index} data-testid={`selected-${nameTest}-row`}>
                    <td>{player.name}</td>
                    <td>{player.type}</td>
                    <td>
                      <button
                        onClick={() => removePlayer(index)}
                        className="btn danger text"
                        data-testid={`selected-${nameTest}-remove`}
                      >
                        Remove
                      </button>
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}