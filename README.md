
<h2>Project Summary 📚 :</h2>
<img align="left" width="153" src="https://user-images.githubusercontent.com/105913917/213880222-bf403731-aee1-460a-afea-381abea7bcf6.jpg"/>
<p align="justify">In this project a detailed review of Amusement Park application. The main objectives of this project to know the package related to the Amusement Park and Activity with best facility and current offer. Searching will be very easy .At a single click will be able to fetch the required data.</p>







<h3 margin-top:100px>Admin module :</h3>
<li>Admin can manage the activity ,add activity,Delete activity and See all customer and their Tickets and activity</li>
<li align="justify">This module provides administrator related functionality. Administrator manages all information and has access rights to add, delete, edit and view the data related to admin, ticket, activity, tiketbookings, etc.</li>
<h3>User module :</h3>
<li>User can view activity List ,customer list, Ticket list etc</li>
<li>This module helps to customer.</li>

<hr>

<table align="center">
<tbody>
<tr align="top">
<td width="20%" align="center">

<h3>Software Requirements</h3>
  
| Command | Description |
| --- | --- |
| Operating System | Windows 10, Linux, Mac |
| Programming Language | Java. |
| IDE Used | Intellij , STS |
| Database  | MySQL 8.0 |
| Framework  | SpringBoot,Maven |
| Architecture  | CRUD, MVC |
  
</td>
<td width="20%" align="center">
<h3>Languages and Tools:</h3>
<table align="center">
<tbody>
<tr valign="top">
<td width="15%" align="center">
<p dir="auto"><span>𝗦𝗽𝗿𝗶𝗻𝗴 𝗧𝗼𝗼𝗹 𝗦𝘂𝗶𝘁</span><br><br></p>
<a><img src="https://spring.io/images/logo-spring-tools-gear-3dbfa4e3714afa9d58885422ec7ac8e5.svg" height="40"></a>
<td width="15%" align="center">
<p dir="auto"><span>𝗜𝗻𝘁𝗲𝗹𝗹𝗶𝗝 𝗜𝗗𝗘𝗔</span><br><br></p>
<a><img src="https://upload.wikimedia.org/wikipedia/commons/9/9c/IntelliJ_IDEA_Icon.svg" height = "40"></a>
</td>
<td width="15%" align="center">
<p dir="auto"><span>𝗝𝗮𝘃𝗮</span><br><br></p>
<a><img src="https://cdn.jsdelivr.net/npm/programming-languages-logos/src/java/java.png" height="40"></a>
</td>
<td width="15%" align="center">
<p dir="auto"><span>𝐌𝐲𝐒𝐐𝐋</span><br><br></p>
<a><img src="https://user-images.githubusercontent.com/103574856/208289464-84fa15f0-e608-48f1-82bd-565e0f776243.png" height="40"></a>
</td>
</tr>

<tr valign="top">
<td width="15%" align="center">
<p dir="auto"><span>𝗦𝗽𝗿𝗶𝗻𝗴 𝗕𝗼𝗼𝘁</span><br><br></p>
<a><img src="https://spring.io/images/projects/spring-edf462fec682b9d48cf628eaf9e19521.svg" height="40"></a>
</td>
<td width="15%" align="center">
<p dir="auto"><span>𝐌𝐚𝐯𝐞𝐧</span><br><br></p>
<a><img src="https://user-images.githubusercontent.com/103574856/208289206-2e81be61-cdf4-4667-ac8f-2bacdadefb25.png" height="40"></a>
</td>
<td width="15%" align="center">
<p dir="auto"><span>𝐇𝐢𝐛𝐞𝐫𝐧𝐚𝐭𝐞</span><br><br></p>
<a><img src="https://user-images.githubusercontent.com/103574856/208289363-3db3173b-fdb9-4306-94fa-05290df04561.PNG" height="40"></a>
</td>
</tr>

</td>
</tr>
</tbody>
</table>

</table>

<hr>

<h3 align="center">MySQL Schema Database Structure</h3>
<p align="center"><img src="https://user-images.githubusercontent.com/103574856/208439456-7afc0143-ac45-48d9-84aa-cb49db09d717.png"/></p>

<h3 id="modules">Modules</h3>
    <ul>
        <li>Login, Logout Module</li>
        <li>User Module</li>
        <li>Admin Module</li>
        <li>Activity Module</li>
        <li>Ticket Module</li>
    </ul>
    <h3 id="features">Features</h3>
    <ul>
        <li>User and Admin authentication &amp; validation with session uuid having.</li>
        <li>Admin Features:<ul>
                <li>Administrator Role of the entire application</li>
                <li>Only registered admins with valid session token can add/update/delete Activity or
                  customer from main database.</li>
            </ul>
        </li>
        <li>User Features:<ul>
                <li>A user can register himself or herself on the platform.</li>
                <li>He/She can check the Activity availabilty.</li>
                <li>If Activity is  available, can book the Ticket for thet activity by providing payment details.</li>
                <li>After booking, he will get booking details for the activity,inside this there will be all
                    details regarding the ticket details ,total cost, etc.</li>
                <li>If the customer want can cancel the booking ,he is able to delete his ticket.</li>
            </ul>
        </li>
    </ul>
    
   <h3 id="installation-run">Installation &amp; Run</h3>
    <ul>
        <li>Before running the API server, you should update the database config inside the <a>application.properties</a>
            file.</li>
        <li>Update the port number, username and password as per your local database config.</li>
    </ul>
    <pre>
        <code>    server.port=<span class="hljs-number">8888</span>
            spring<span class="hljs-selector-class">.datasource</span><span class="hljs-selector-class">.url</span>=jdbc:mysql:<span class="hljs-comment">//localhost:3306/ventureDB;</span>
            spring<span class="hljs-selector-class">.datasource</span><span class="hljs-selector-class">.driver-class-name</span>=com<span class="hljs-selector-class">.mysql</span><span class="hljs-selector-class">.cj</span><span class="hljs-selector-class">.jdbc</span><span class="hljs-selector-class">.Driver</span>
            spring<span class="hljs-selector-class">.datasource</span><span class="hljs-selector-class">.username</span>=root
            spring<span class="hljs-selector-class">.datasource</span><span class="hljs-selector-class">.password</span>=root
        </code>
    </pre>
    
    
<h3 align="center">Contributors</h3>
<table align="center">
<tbody>
<tr valign="top">

<td width="25%" align="center">
<p dir="auto"><span>Admin Developer</span><br><br></p>
<a><img src="https://user-images.githubusercontent.com/105913917/213881683-27611aa3-469d-42b1-8c7b-d011d3ca0ff5.PNG"
 height="100"></a>
<p dir="auto"><span>Rajul Tiwari</span><br></p>
</td>

<td width="25%" align="center">
<p dir="auto"><span>Admin Developer</span><br><br></p>
<a><img src="https://user-images.githubusercontent.com/105913917/213882007-284fb978-f107-47ae-ad59-eb098291e924.PNG"
height="100"></a>
<p dir="auto"><span>Abhinandan Rauniyar</span><br></p>
</td>

<td width="25%" align="center">
<p dir="auto"><span>User Developer</span><br><br></p>
<a><img src="https://avatars.githubusercontent.com/u/105913917?v=4" height="100"></a>
<p dir="auto"><span>Vedprakash Paswan</span><br></p>
</td>

<td width="25%" align="center">
<p dir="auto"><span>User Developer</span><br><br></p>
<a><img src="https://user-images.githubusercontent.com/105913917/213881240-fafb16a4-9a09-4015-81c2-a58b1164058e.png"
 height="100"></a>
<p dir="auto"><span>Shivam Shahu</span><br></p>
</td>

</tr>
</tbody>
</table>
