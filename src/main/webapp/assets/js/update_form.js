
window.onload= course_load;


    async function course_load (e) {
    // e.preventDefault();
    // e.stopPropagation();
    var key = sessionStorage.getItem("key");
   // alert("Welcome  " + key);
document.getElementById("course_id").value=key;
   // let course_form = document.getElementById('course-validation');

    let response = await fetch("api/courses/course_data", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            course_id: key
        })
    });
    let course_data=await response.json();
    // console.log(course_data[0]['name']);
    // console.log(course_data['description']);

    // course_data.forEach(course_data => {
       document.getElementById('course_id').value=course_data['course_id'];
    document.getElementById('capacity').value=course_data['capacity'];
    document.getElementById('course_code').value=course_data['course_code'];
     document.getElementById('credits').value=course_data['credits'];
    document.getElementById('description').value=course_data['description'];
    document.getElementById('faculty').value=course_data['faculty'];
    document.getElementById('name').value=course_data['name'];
     document.getElementById('term').value=course_data['term'];
     document.getElementById('year').value=course_data['year'];
// });
    }




let course_form = document.getElementById('course-validation');

let update_btn=document.getElementById('update_btn');
// course_form.onsubmit = async (e) => {



course_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (course_form.checkValidity() === true) {
        let response = await fetch('api/courses/update', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                course_id:  document.getElementById('course_id').value,
                capacity:  document.getElementById('capacity').value,
                course_code:  document.getElementById('course_code').value,
                credits:  document.getElementById('credits').value,
                description:  document.getElementById('description').value,
                faculty:  document.getElementById('faculty').value,
                name:  document.getElementById('name').value,
                term:  document.getElementById('term').value,
                year:  document.getElementById('year').value,
            })
        });
        let result = await response;   //response from backend(true or false) is returned to front end
        if(result["status"]===200){
            console.log("DONE");
           // sessionStorage.setItem("favoriteMovie", "abc");
            location.href = "dashboard.html";
        }else{
            console.log("not DONE");
        }

    }
});








// async function update_data(e){
//    //  e.preventDefault();
//    // e.stopPropagation();
//     let response = await fetch("api/courses/update", {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json;charset=utf-8'
//         },
//         body: JSON.stringify({
//             course_id:  document.getElementById('course_id').value,
//             capacity:  document.getElementById('capacity').value,
//             course_code:  document.getElementById('course_code').value,
//             credits:  document.getElementById('credits').value,
//             description:  document.getElementById('description').value,
//             faculty:  document.getElementById('faculty').value,
//             name:  document.getElementById('name').value,
//             term:  document.getElementById('term').value,
//             year:  document.getElementById('year').value,
//
//         })
//     });
//     let result = await response();
//    // window.location.href('dashboard.html');
//     if (result['status']===200) {
//        // alert("success");
//          //document.getElementById("course-success").style.display = "none";
//         // document.getElementById("course-alert").style.display = "block";
//          window.location.href('dashboard.html');
//
//     } else {
//         document.getElementById("course-alert").style.display = "none";
//         document.getElementById("course-success").style.display = "block";
//
//     }
//     console.log(result.status);
// }




















//  e.preventDefault();
   // e.stopPropagation();
   //  if (course_form.checkValidity() === true) {
   //      let form_data = new FormData();
   //
   //
   //      form_data.append('course_id', document.getElementById('course_id').value);
   //      form_data.append('capacity', document.getElementById('capacity').value);
   //      form_data.append('course_code', document.getElementById('course_code').value);
   //      form_data.append('credits', document.getElementById('credits').value);
   //      form_data.append('description', document.getElementById('description').value);
   //      form_data.append('faculty', document.getElementById('faculty').value);
   //      form_data.append('name', document.getElementById('name').value);
   //      form_data.append('term', document.getElementById('term').value);
   //      form_data.append('year', document.getElementById('year').value);

        // $.ajax({
        //   type: "POST",
        //   url: "api/courses/register",
        //   enctype: 'multipart/form-data',
        //   data: form_data,
        //   processData: false,
        //   contentType: false,
        // }).done(function(response, status) {
        //   console.log(response, status);
        // });



// async function fetch_course_id() {
//
//     var favoritemovie = sessionStorage.getItem("favoriteMovie");
//     alert("Welcome  " + favoritemovie);
// }