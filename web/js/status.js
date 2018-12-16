var xHRObject = new XMLHttpRequest();


function changeStatus () {
    var newStatusValue = document.getElementById("status").value;
    xHRObject.open("GET", "Controller?action=ChangeStatus&status=" + newStatusValue, true);
    xHRObject.onreadystatechange = getStatus;
    xHRObject.send(null);
}

function getStatus(){
    if (xHRObject.readyState == 4){
        if (xHRObject.status == 200){
            var response = JSON.parse(xHRObject.responseText);

            var statusDiv = document.getElementById("currentStatus");
            var statusParagraph = statusDiv.childNodes[1];

            if (statusParagraph == null){
                statusParagraph = document.createElement('p')
                statusParagraph.id = "statusText";
                var statusText = document.createTextNode(response.status);
                statusParagraph.appendChild(statusText);
                statusDiv.appendChild(statusParagraph);
            }
            else {
                var statusText = document.createTextNode(response.status);
                statusParagraph.removeChild(statusParagraph.childNodes[0]);
                statusParagraph.appendChild(statusText);
            }
        }
    }
}









