import React, { useState } from "react";

function TransactionTable({ txns }) {

  //add -- start ----
  const [filteredTxns, setFilteredTxns] = useState(txns);    
  const [date, setDate] = useState(""); 
  const [sortAsc, setSortAsc] = useState(true); 

  const handleFilter = () => {
        const inputDate = document.getElementById("date").value;
        if (!inputDate) return;
        const result = txns.filter((txn) => txn.date === inputDate);
        setFilteredTxns(result);
  };

  const sort = () => {
    const sorted = [...filteredTxns].sort((a, b) =>
      sortAsc ? a.amount - b.amount : b.amount - a.amount
    );
    setFilteredTxns(sorted);
    setSortAsc(!sortAsc);
  };

  //add -- end ----


  //Below change
  //1. <input> onChange
  //2. <button> onClick
  //3.  <tbody> {filteredTxns.map(
  return (
    <div className="layout-column align-items-center mt-50">
      <section className="layout-row align-items-center justify-content-center">
        <label className="mr-10">Transaction Date</label>
        <input
          id="date"
          type="date"
          defaultValue="2019-11-29"
          onChange={(e) => setDate(e.target.value)}      
          role="search"
        />
        <button className="small" onClick={handleFilter}>         
          Filter
        </button>   
      </section>

      <div className="card mt-50">
        <table className="table">
          <thead>
            <tr className="table">
              <th className="table-header">Date</th>
              <th className="table-header">Description</th>
              <th className="table-header">Type</th>
              <th className="table-header">
                <span id="amount" onClick={sort} role="button">
                  Amount ($)
                </span>
              </th>
              <th className="table-header">Available Balance</th>
            </tr>
          </thead>
          <tbody>
            {filteredTxns.map((txn, index) => (
              <tr key={index}>
                <td>{txn.date}</td>
                <td>{txn.description}</td>
                <td>{txn.type === 1 ? "Debit" : "Credit"}</td>
                <td>{txn.amount}</td>
                <td>{txn.balance}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default TransactionTable;
