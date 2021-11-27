async function register() {
    let datos={};
    datos.name = document.getElementById("txtname").value
    datos.playNumber = document.getElementById("txtnumber").value

    const request = await fetch('post/add', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    const jugadores = await request.json();
    alert("Ya se registró sopla mondá")
    document.getElementById("txtname").value = ""
    document.getElementById("txtnumber").value = ""
}

async function getData(){
    const request = await fetch('post/list',{
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },

    });

    const jugadores = await request.json();

    let listHtml = ''

    let i = 1
    for (let jugador of jugadores) {
        let jugadorHtml = '<tr>' +
                          '<th scope="row">'+(i)+'</th>' +
                          '<td>'+jugador.name+'</td>' +
                          '<td>'+jugador.playNumber+'</td>' +
                          '</tr>'
        listHtml+=jugadorHtml
        i = i+1
    }

    document.querySelector("#tablePlayers tbody").outerHTML = listHtml
}