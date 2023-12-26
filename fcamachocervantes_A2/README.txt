Note:
The game isn't playable there isn't any logic behind it. The history screen also only includes a dummy
list of games and and since the game is unplayble can't record any new games.

1. Creating the navgraph was extremely easy. The archetecture we were taught for Samodelkin has proved really useful and easy
for creating new navgraphs.
2. I had the state for the settings along with the score keeping stored in my view model. This didn't really change much
since it was simple enough to pass down the state to my settings buttons and have them call a function in the viewmodel to switch
the button state when clicked. I had my viewmodel being passed to the NavHost which would then pass the
viewmodel to each screen whenever it was navigated to. Again this didn't really pose any challenge
because of encapsulation within each screen so as long as it recieved the viewmodel at some point it functioned
without issue. Using the MVVM architecture proved useful in keeping everything modular so that it was easy
to add new functionalities without much hassle and without effecting everything below where the change was occuring.