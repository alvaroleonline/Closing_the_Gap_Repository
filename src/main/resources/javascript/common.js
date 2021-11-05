


// Initialize DataTables

$(document).ready( function () {
    $('#table_id').DataTable();
} );



// *** HEADER HIDE AT SCROLLING JS (Currently not active)

var prevScrollpos = window.pageYOffset;
var lastScrollTop = 0;

window.onscroll = function() {
    var currentScrollPos = window.pageYOffset;
   

    if (prevScrollpos >= currentScrollPos){
        document.getElementById("header").style.top = "0";
    } else {
        document.getElementById("header").style.top = "-50px";
    }
    prevScrollpos = currentScrollPos;
}



/// Mission page collapsible

var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var contenthidden = this.nextElementSibling;
    if (contenthidden.style.maxHeight){
      contenthidden.style.maxHeight = null;
    } else {
      contenthidden.style.maxHeight = contenthidden.scrollHeight + "px";
    } 
  });
}




