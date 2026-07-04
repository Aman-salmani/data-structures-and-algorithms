# Trie (Prefix Tree) - Java Notes

## What is a Trie?

A **Trie (Prefix Tree)** is a tree-based data structure used to **store and search strings efficiently**.

Each node represents **one character**, and the complete path from the root to a node represents a word or prefix.

### Common Applications

- Dictionary
- Auto Complete
- Spell Checker
- Prefix Search
- Contact Search
- Word Search
- IP Routing

---

# Why Use Trie?

Suppose we store:

```
cat
car
can
```

Instead of storing each word separately, Trie stores the common prefix only once.

```
        root
          |
          c
          |
          a
       /  |  \
      t   r   n
```

This makes prefix searching very efficient.

---

# Advantages

- Fast insertion
- Fast searching
- Efficient prefix search
- Shared prefixes reduce repeated storage

---

# Disadvantages

- Higher memory usage
- More complex implementation than HashMap

---

# Time Complexity

| Operation | Complexity |
|-----------|------------|
| Insert | O(L) |
| Search | O(L) |
| StartsWith | O(L) |

> **L = Length of the word**

---

# Trie Node Structure

Each Trie node contains:

- An array of 26 child references (`a-z`)
- A boolean `isEnd` to mark the end of a word

```java
class TrieNode {

    TrieNode[] children = new TrieNode[26];

    boolean isEnd = false;

}
```

### Character Mapping

```
children[0]  -> a
children[1]  -> b
children[2]  -> c
...
children[25] -> z
```

---

# Trie Structure

A Trie contains only one **root node**.

The root node **does not store any character**.

It simply acts as the starting point for every word.

```java
class Trie {

    TrieNode root;

    Trie() {

        root = new TrieNode();

    }

}
```

---

# Insert Operation

### Purpose

Stores a new word inside the Trie.

### Flow

```
Start

↓

curr = root

↓

For every character

↓

Find index

↓

Node exists?

├── No → Create new node
└── Yes → Move to next node

↓

Move curr

↓

Repeat

↓

Mark last node

isEnd = true
```

### Java

```java
public void insert(String word) {

    TrieNode curr = root;

    for(char ch : word.toCharArray()) {

        int idx = ch - 'a';

        if(curr.children[idx] == null) {

            curr.children[idx] = new TrieNode();

        }

        curr = curr.children[idx];
    }

    curr.isEnd = true;
}
```

### Example

Insert:

```
cat
car
can
```

Trie becomes

```
        root
          |
          c
          |
          a
       /  |  \
      t   r   n
```

---

# Search Operation

### Purpose

Checks whether a **complete word** exists.

### Flow

```
Start

↓

curr = root

↓

For every character

↓

Character exists?

├── No → Return false
└── Yes → Move forward

↓

Loop Finished

↓

isEnd == true ?

├── Yes → Return true
└── No → Return false
```

### Java

```java
public boolean search(String word) {

    TrieNode curr = root;

    for(char ch : word.toCharArray()) {

        int idx = ch - 'a';

        if(curr.children[idx] == null) {

            return false;

        }

        curr = curr.children[idx];
    }

    return curr.isEnd;
}
```

### Example

Stored words

```
cat
car
apple
```

```
search("cat")   → true

search("ca")    → false

search("dog")   → false
```

---

# StartsWith Operation

### Purpose

Checks whether **any word starts with the given prefix**.

Unlike `search()`, it **does not check `isEnd`**.

### Flow

```
Start

↓

curr = root

↓

For every character

↓

Character exists?

├── No → Return false
└── Yes → Move forward

↓

Loop Finished

↓

Return true
```

### Java

```java
public boolean startsWith(String prefix) {

    TrieNode curr = root;

    for(char ch : prefix.toCharArray()) {

        int idx = ch - 'a';

        if(curr.children[idx] == null) {

            return false;

        }

        curr = curr.children[idx];
    }

    return true;
}
```

### Example

Stored words

```
apple
apply
application
```

```
startsWith("app") → true

startsWith("ap")  → true

startsWith("dog") → false
```

---

# Search vs StartsWith

| Feature                      | search()  | startsWith() |
|------------------------------|-----------|--------------|
| Checks complete word         |    Yes    | No           |
| Uses `isEnd`                 |    Yes    | No           |
| Returns true for prefix only |    No     | Yes          |

Example

```
Stored Word

apple
```

| Method | Input | Output |
|---------|-------|--------|
| search() | app | false |
| startsWith() | app | true |

---

# Word Break Problem

### Problem

Given:

- A dictionary
- A string

Determine whether the string can be split into valid dictionary words.

Example

Dictionary

```
i
like
sam
samsung
```

Input

```
ilikesamsung
```

Output

```
true
```

Because

```
i + like + samsung
```

### Idea

- Store all dictionary words in Trie.
- Check every possible prefix.
- If prefix exists, solve the remaining string recursively or using DP.

---

# Prefix Problem (Unique Prefix)

Given

```
zebra
dog
duck
dove
```

Find the shortest unique prefix of each word.

Output

```
z
dog
du
dov
```

### Idea

Store a **frequency count** in every Trie node.

While inserting:

```
Increase frequency
```

While traversing:

```
frequency == 1

↓

Unique Prefix Found
```

Node Structure

```java
class TrieNode {

    TrieNode[] children = new TrieNode[26];

    boolean isEnd;

    int frequency;

}
```

---

# Trie vs HashMap

| Feature | Trie | HashMap |
|----------|------|----------|
| Word Search | ✅ | ✅ |
| Prefix Search | ✅ | ❌ |
| Auto Complete | ✅ | ❌ |
| Memory Usage | Higher | Lower |

---

# Quick Revision

```
Trie = Prefix Tree

Each node stores:
- children[26]
- isEnd

Root:
- Empty node
- Starting point

Insert:
- Traverse characters
- Create node if needed
- Mark last node isEnd = true

Search:
- Traverse
- Return isEnd

StartsWith:
- Traverse
- No need to check isEnd

Time Complexity

Insert      O(L)
Search      O(L)
StartsWith  O(L)

Applications

✔ Dictionary
✔ Auto Complete
✔ Prefix Search
✔ Spell Checker
✔ Contact Search
✔ Word Break
✔ Unique Prefix
```