About
===
This is a Software Engineering project.

---

Authors
===
Filip Bugaj  
Mikołaj Leśny  
Agata Nowicka  
Tomasz Paluszkiewicz

---

GET
===
To recieve data in JSON use GET request in form:
```
http://localhost:8080/example_text?transforms=example_transform
```
It returns data in format:
```
{"transforms":["example_transform"],
 "text":"example_text",
 "shortestPath":{"path":[],"costSum":0.0}}
```

---

POST
===
To send data to service use POST request containing JSON in format like this:
```
{"nodes":[1, 2, 3, 4, 5], "connections": [[1,2],[5,3],[2,3]] }
```
It should return same data you sent.
