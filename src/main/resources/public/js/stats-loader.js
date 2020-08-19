const json = JSON.parse(document.getElementById("payload").innerHTML)

function getVictoryState(token) {
    switch (token) {
        case "$WIN":
            return {html: "VICTORY", color: "rgb(0, 200, 0)"}
        case "$LOSS":
            return {html: "ELIMINATED", color: "rgb(206,38,38)"}
        case "$CARRY":
            return {html: "CARRIED", color: "rgb(255,141,2)"}
        default:
            return {html: token, color: "#808080"}
    }
}

document.getElementById("modename").innerHTML = json.modeName;
createHeader(json.header);

function createHeader(header) {
    const table = document.getElementById("table");
    const row = document.createElement("tr");

    for (let i = 0; i < header.length; i++) {
        const tableHeader = document.createElement("th");
        tableHeader.innerHTML = header[i];
        row.appendChild(tableHeader);
    }

    table.appendChild(row);
}

function addRow(rowData) {
    const table = document.getElementById("table");
    const row = document.createElement("tr");

    for (let i = 0; i < rowData.length; i++) {
        const tableData = document.createElement("td");
        const victoryState = getVictoryState(rowData[i].toString())
        tableData.innerHTML = victoryState.html
        tableData.style.color = victoryState.color
        row.appendChild(tableData);
    }

    table.appendChild(row);
}

for (let index in json.rows) {
    addRow(json.rows[index]);
}