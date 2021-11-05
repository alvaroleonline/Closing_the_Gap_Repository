

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

/*

// Hide Header on on scroll down
var didScroll;
var lastScrollTop = 0;
var delta = 5;
var navbarHeight = $('header').outerHeight();

$(window).scroll(function(event){
    didScroll = true;
});

setInterval(function() {
    if (didScroll) {
        hasScrolled();
        didScroll = false;
    }
}, 250);

function hasScrolled() {
    var st = $(this).scrollTop();
    
    // Make sure they scroll more than delta
    if(Math.abs(lastScrollTop - st) <= delta)
        return;
    
    // If they scrolled down and are past the navbar, add class .nav-up.
    // This is necessary so you never see what is "behind" the navbar.
    if (st > lastScrollTop && st > navbarHeight){
        // Scroll Down
        $('header').removeClass('nav-down').addClass('nav-up');
    } else {
        // Scroll Up
        if(st + $(window).height() < $(document).height()) {
            $('header').removeClass('nav-up').addClass('nav-down');
        }
    }
    
    lastScrollTop = st;
}

// Credit: Gill @ codeseek.com */


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


// Initialize DataTables

$(document).ready( function () {
    $('#table_id').DataTable();
} );



