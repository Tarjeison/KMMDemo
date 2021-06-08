//
//  DataClassDemoTest.swift
//  iosApp
//
//  Created by Trym Tarjeison Lekva on 08/06/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

func testDemo() {
    let animal = DataClassDemo().getAnimalDog()
    guard let dog = animal as? Animal.Dog else {
        return
    }
    print(dog.isAGoodBoy)
}

