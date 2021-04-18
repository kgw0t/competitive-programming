package main

import (
	"fmt"
	"math/big"
)

func pow(x, n *big.Int) *big.Int {
	b := big.NewInt(0)
	if n.Cmp(big.NewInt(0)) == 0 {
		return big.NewInt(1)
	}
	return b.Mul(x, pow(x, n.Sub(n, big.NewInt(1))))
}

func pow_r(x, n *big.Int) *big.Int {
	// fmt.Println("x", x, "n", n)
	b := big.NewInt(0)
	if n.Cmp(big.NewInt(0)) == 0 {
		return big.NewInt(1)
	}
	if b.Mod(n, big.NewInt(2)).Cmp(big.NewInt(0)) == 0 {
		return pow_r(pow(x, big.NewInt(2)), n.Div(n, big.NewInt(2)))
	}
	return b.Mul(x, pow_r(pow(x, big.NewInt(2)), n.Div(n, big.NewInt(2))))
}

func pow_k(x, n *big.Int) *big.Int {
	b := big.NewInt(0)
	if n.Cmp(big.NewInt(0)) == 0 {
		return big.NewInt(1)
	}
	k := big.NewInt(1)
	for n.Cmp(big.NewInt(1)) == 1 {
		if b.Mod(n, big.NewInt(2)).Cmp(big.NewInt(0)) != 0 {
			k.Mul(k, x)
		}
		x.Mul(x, x)
		n.Div(n, big.NewInt(2))
	}
	return b.Mul(x, k)
}

func main() {
	// a := big.NewInt(10)
	// b := big.NewInt(5)
	// fmt.Println(a.Sub(a, b))
	// fmt.Println(a)
	// fmt.Println(b)
	x := big.NewInt(2)
	n := big.NewInt(1000000000)
	fmt.Println(pow_k(x, n))
}
