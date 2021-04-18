package main

import (
	"fmt"
	"math"
	"math/big"
)

func permutation(n *big.Int, k *big.Int) *big.Int {
	b := big.NewInt(0)
	v := big.NewInt(1)
	if k.Sign() == 1 && k.Cmp(n) != 1 {
		i := big.NewInt(0)
		for ; k.Cmp(i) == 1; i.Add(i, big.NewInt(1)) {
			v.Mul(v, b.Sub(n, i))
		}
	} else if k.Cmp(n) == 1 {
		v = big.NewInt(0)
	}
	return v
}

func factorial(n *big.Int) *big.Int {
	m := big.NewInt(1)
	return permutation(n, m.Sub(n, m))
}

func combination(n *big.Int, k *big.Int) *big.Int {
	b := big.NewInt(0)
	return b.Div(permutation(n, k), factorial(k))
}

func main() {
	var n, a, b int
	fmt.Scan(&n, &a, &b)

	r := big.NewInt(math.Pow)

	fmt.Println(uint64(math.Pow(float64(2), float64(n))) - 1 - combination(n, a) - combination(n, b))
}
