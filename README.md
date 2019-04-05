# Dumb Spray

… is a joke mod that adds two potions: Potion of Dumbness and Potion of Super Dumbness.

  - Potion of Dumbness will clear all AI tasks of target entity (implying that target must be an `EntityLiving`),
    and add a idle looking task, until the entity is reloaded from chunk due to whatever reason(s).
  - Potion of Super Dumbness will mark target entity with `setNoAI(true)`, effectively "freezing" them.

Additionally, a command `/dumb <target>` is provided to make target entity dumb, which is equivalent to use
Potion of Dumbness on the said target. The `<target>` part may be a selector.

#### Reference

https://blog.phoenixlzx.com/2017/05/05/reduce-minecraft-server-lag-without-limit-mob-amount/