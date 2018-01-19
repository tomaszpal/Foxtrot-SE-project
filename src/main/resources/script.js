$.getJSON( "http://localhost:8080/xd", function( data ) {
    var items = [];
    $.each( data, function( key, val ) {
        items.push( "<li id='" + key + "'>" + key + ": " + val + "</li>" );
    });

    $( "<ul/>", {
        "class": "my-new-list",
        html: items.join( "" )
    }).appendTo( ".requestResult" );
});


var submitJSON;
var submit = [];

var nodes = [];
var nodesJSON;
$( "#nodeInput" ).click(function( event ) {
    nodes.push({
        name: $(nodeName).val(),
        type: $(nodeType).val()
    });
    nodesJSON = JSON.stringify(nodes);
    $("<p>", {
        "class": "nodeItem",
         html: "Name: \"" + $(nodeName).val() + "\"   Type: " + $(nodeType).val()
    }).appendTo("#nodeList");
    console.log("Nodes: \n" + nodesJSON);
});

var connections = [];
var connectionJSON;
$( "#connectionInput" ).click(function( event ) {
    connections.push({
        first: $(connectionId1).val(),
        second: $(connectionId2).val(),
        cost: $(connectionCost).val()
    });
    connectionJSON = JSON.stringify(connections);
    $("<p>", {
        "class": "connectionItem",
        html: "Id1: " + $(connectionId1).val() + " Id2 : " + $(connectionId2).val()
    }).appendTo("#connectionList");
    console.log("Connections: \n" + connectionJSON);
});

$( "#sendButton" ).click(function( event ) {
    submit.push({
        nodes: nodes,
        connections: connections
    });
    submitJSON = JSON.stringify(submit);
    console.log("Sent: \n" + submitJSON);
});


