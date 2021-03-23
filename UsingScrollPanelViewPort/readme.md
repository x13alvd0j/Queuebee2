# Adding Content to a (fixed size) JPanel
In here my solution to add content to a `JPanel` is to put the
`JPanel` inside a `JScrollPane` and set the "`ViewportView`" of the `JScrollPane` on the `JPanel`.

To make sure everything is displayed and rendered properly, I had to use `updateUI`, `revalidate` and `repaint` on the `JScrollPane` and then `pack()`<sup>1</sup> on the main `JFrame`.






<sup>1</sup> Without calling `pack` on the main `JFrame`, the `JPanel`s inside the `JScrollPane` would have a center region around the `JLabel` 'lower' than the rest of the Jpanel.
