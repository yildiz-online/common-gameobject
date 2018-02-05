/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2018 Grégory Van den Borre
 *
 *  More infos available: https://www.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 */

package be.yildizgames.common.gameobject;

import be.yildizgames.common.geometry.Point3D;

/**
 * Common interface for all movable objects.
 * Mutable class.
 *
 * @author Grégory Van den Borre
 */
public interface Movable extends Deletable {

    /**
     * Attach this object to another, this object will always follow the other moves and rotations.
     *
     * @param other Object to follow.
     */
    //@Requires("other != null")
    void attachTo(Movable other);

    /**
     * Attach this object to another, this object will always follow the other moves and rotations, if the other object is deleted, this one will simply be detached.
     *
     * @param other Object to follow.
     */
    //@Requires("other != null")
    void attachToOptional(Movable other);

    void detachFromParent();

    /**
     * @return The object current position relative to its parent.
     */
    Point3D getPosition();

    /**
     * Set the object position.
     *
     * @param newPosition New position.
     */
    void setPosition(Point3D newPosition);

    /**
     * @return The object current position relative to the world.
     */
    Point3D getAbsolutePosition();

    /**
     * @return The object current direction relative to its parent.
     */
    Point3D getDirection();

    /**
     * Set the object direction.
     *
     * @param newDirection New direction [assert not null].
     */
    void setDirection(Point3D newDirection);

    /**
     * @return The object current direction relative to the world.
     */
    Point3D getAbsoluteDirection();

    /**
     * Set the object position.
     *
     * @param posX Position x value.
     * @param posY Position y value.
     * @param posZ Position z value.
     */
    void setPosition(float posX, float posY, float posZ);

    /**
     * Set the object direction.
     *
     * @param dirX Direction x value.
     * @param dirY Direction y value.
     * @param dirZ Direction z value.
     */
    void setDirection(float dirX, float dirY, float dirZ);

    void addOptionalChild(Movable child);

    void addChild(Movable child);

    void removeChild(Movable child);

    Movable getInternal();
}
