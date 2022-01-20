window.onload = fetch_courses;
//window.onload=fetch_cid;
var table = document.getElementById("tableBody");
 var selected = table.getElementsByClassName('selected');
table.onclick = highlight;



function highlight(e) {
    if (selected[0]) selected[0].className = '';
    e.target.parentNode.className = 'selected';
    var val =$(".selected td:first").html();
    //console.log(val);
}

async function delete_course()
{  var value =$(".selected td:first").html();
   // var value =$(".selected td:first").html();
//value = value || "No row Selected";
    console.log(value);

    let response = await fetch("api/courses/delete", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            course_id: value
        })
    });

    window.location.reload(true);
   // alert("Course deletion successful!");
    let result=await response.json();
    alert(response.message);
    console.log(result);
    // if(response.ok)
    // {
    //    alert('course deletion successful');
    //    window.location.reload(true);
    //  }
    // else
    // {
    //     alert('course deletion failed');
    // }
}
// $("#delete_btn").click(function(){
//     var value =$(".selected td:first").html();
//     value = value || "No row Selected";
//     alert(value);
//
// });


async function fetch_courses() {
    let response = await fetch("api/courses/get");
    let courses = await response.json(); // read response body and parse as JSON
    console.log("hey there");


    let table = document.getElementById("tableBody");

    courses.forEach(courses => {
        let row = table.insertRow();

        let CourseID = row.insertCell(0);
        CourseID.innerHTML = courses['course_id'];
        CourseID.setAttribute("class","course_id")

        let Name = row.insertCell(1);
        Name.innerHTML = courses['name'];
        Name.setAttribute("class","name")

        let CourseCode = row.insertCell(2);
        CourseCode.innerHTML = courses['course_code'];
        CourseCode.setAttribute("class","course_code")

        let Description = row.insertCell(3);
        Description.innerHTML = courses['description'];
        Description.setAttribute("class","description")

        let Year = row.insertCell(4);
        Year.innerHTML = courses['year'];
        Year.setAttribute("class","year")


        let Term = row.insertCell(5);
        Term.innerHTML = courses['term'];
        Term.setAttribute("class","term")

        let Credits = row.insertCell(6);
        Credits.innerHTML = courses['credits'];
        Credits.setAttribute("class","credits")

        let Capacity = row.insertCell(7);
        Capacity.innerHTML = courses['capacity'];
        Capacity.setAttribute("class","capacity")

        let Faculty=row.insertCell(8);
        Faculty.innerHTML=courses['faculty'];
        Faculty.setAttribute("class","faculty")

        let Count=row.insertCell(9);
        Count.innerHTML=courses['count'];   //accessing student list in courses object
        Count.setAttribute("class","count")

       //console.log(courses['students']['first_name']);
    });
}

async function update()
{
    var val =$(".selected td:first").html();
//value = value || "No row Selected";
    window.location.href = 'update_form.html';
    sessionStorage.setItem("key", val);

}


function sortTable(ascending, columnClassName, tableId) {
    var tbody = document.getElementById(tableId).getElementsByTagName(
        "tbody")[0];
    var rows = tbody.getElementsByTagName("tr");
    var unsorted = true;
    /* while (unsorted)
            unsorted = false*/
    var i=0;
    for (i = 0; i < rows.length-1; i++)
    {
        for (var r = 0; r < rows.length-i-1; r++) {
            var row = rows[r];
            var nextRow = rows[r + 1];
            var value = row.getElementsByClassName(columnClassName)[0].innerHTML;
            var nextValue = nextRow.getElementsByClassName(columnClassName)[0].innerHTML;
            value = value.replace(',', ''); // in case a comma is used in float number
            nextValue = nextValue.replace(',', '');
            if (!isNaN(value)) {
                value = parseFloat(value);
                nextValue = parseFloat(nextValue);
            }
            if(ascending==="true")
            {
                if (value > nextValue) {
                    tbody.insertBefore(nextRow, row);
// unsorted = true;
                }
            }
        else{
                if (value < nextValue) {
                    tbody.insertBefore(nextRow, row);
// unsorted = true;
                }
            }
        }
    }
}



//  function fetch_course_id(val) {
//    console.log("fetch cid called");
//    console.log(val);
//     document.getElementById("course_id").value=val;
// }