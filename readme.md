# Gilded Rose with approval tests and Strategy pattern
Every commit is a step to arrive this solution. The first steps are very similar to the approach of
Emily bache in the following videos:

* Approval tests in the similar way Emily Bache started in the following video:
https://www.youtube.com/watch?v=zyM2Ep28ED8

* Refactoring the code with the same technique that Emily Bache shows in the following video:
https://www.youtube.com/watch?v=OJmg9aMxPDI

From this point, in this solution we apply the Strategy pattern and polymorphism, but this approach is
distint of the alternative approach of Emily Bache which you can see here:
https://www.youtube.com/watch?v=NADVhSjeyJA

Every commit is a step:
* empty project with dummy test: Junit 5
* dummy test with approval test: to see the approach with this library
* first approval test with one item
* approval tests and combinations - covering all the code
* approval tests and combinations - prepared for refactoring
* duplication the code in the if to simplify with coverage the code: Aged Bried
* duplication the code in the if to simplify with coverage the code: Backstage
* simplification of the ifs in the three main cases
* separation in several methods, previous to extract responsibilities
* extraction of Strategy classes previous for refactoring
* Strategy pattern and a builder pattern
* Refactoring of Strategies, hierarchy and polymorphism
* Refactoring and ready to add the new feature: Conjured
* Including a new type of item: Conjured and characterization tests for the program
* Refactoring, packages and change the names. We have changed the builder with a container (Performance)



https://github.com/emilybache/GildedRose-Refactoring-Kata

# Gilded Rose Requirements Specification

Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a
prominent city ran by a friendly innkeeper named Allison. We also buy and sell only the finest goods.
Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We
have a system in place that updates our inventory for us. It was developed by a no-nonsense type named
Leeroy, who has moved on to new adventures. Your task is to add the new feature to our system so that
we can begin selling a new category of items. First an introduction to our system:

	- All items have a SellIn value which denotes the number of days we have to sell the item
	- All items have a Quality value which denotes how valuable the item is
	- At the end of each day our system lowers both values for every item

Pretty simple, right? Well this is where it gets interesting:

	- Once the sell by date has passed, Quality degrades twice as fast
	- The Quality of an item is never negative
	- "Aged Brie" actually increases in Quality the older it gets
	- The Quality of an item is never more than 50
	- "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	- "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
	Quality drops to 0 after the concert

We have recently signed a supplier of conjured items. This requires an update to our system:

	- "Conjured" items degrade in Quality twice as fast as normal items

Feel free to make any changes to the UpdateQuality method and add any new code as long as everything
still works correctly. However, do not alter the Item class or Items property as those belong to the
goblin in the corner who will insta-rage and one-shot you as he doesn't believe in shared code
ownership (you can make the UpdateQuality method and Items property static if you like, we'll cover
for you).

Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a
legendary item and as such its Quality is 80 and it never alters.