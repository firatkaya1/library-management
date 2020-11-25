    var modal = document.getElementById("myModal");
    var tbody = document.getElementsByTagName('tbody')[0];
    var inputs = document.getElementsByTagName('input')
    var span = document.getElementsByClassName("close")[0];
    console.log("length :"+document.getElementsByTagName('input').length);
    function saveData(){
        modal.style.display = "block";
        document.getElementById("updateData").style.display="none";
        document.getElementById("saveData").style.display="block";
        document.getElementById("deleteData").style.display="none";
        for(var a = 0;a < inputs.length;a++){
            inputs[a].value = "";
        }
    }

    function selectedButton(i) {
        modal.style.display = "block";
        for(var a = 0;a < 3;a++){
            inputs[a].value = tbody.getElementsByTagName('tr')[i-1].getElementsByTagName('td')[a].innerHTML;
        }
        document.getElementById("saveData").style.display="none";
        document.getElementById("updateData").style.display="block";
        document.getElementById("deleteData").style.display="block";
        document.getElementById("deleteData").action = "/book/"+tbody.getElementsByTagName('tr')[i].getElementsByTagName('td')[0].innerHTML;
        }
        
    span.onclick = function() {
        modal.style.display = "none";
    }
    window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
    
    

}