Francisco Camacho (fcamachocervantes@mines.edu)
A3 Movie Database

Right now the application doesn't actually perform any query to the API and only has the screens,
nav graph, and MVVM in place along with the database. You can't view the Movie details screen
since it isn't possible to query the API for a movie to add to the list but the screen does exist.

I was able to build out all the back end functionality so there
is a view model and nav graph in place. The database is built as well
and has the corresponding dao and interfaces. I wasn't able to get the implementation
working with the imdb API so it's not actually possible to add a movie to the list.
The functionality for the title/get-videos doesn't exist either. All the screen do exist though.
The user is able to type to search for a movie however it won't actually hit the API and make the 
correct request. If you look at the code you can see that everything is there. If I
was able to correctly get the API fetchr to work and be able to query the data base the other
parts would've fallen into place and worked correctly. It's just that without the API fetchr
working properly you can't really see anything from running the app.

